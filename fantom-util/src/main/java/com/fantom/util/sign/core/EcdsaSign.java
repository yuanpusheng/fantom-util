package com.fantom.util.sign.core;

import org.springframework.util.Base64Utils;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/22 11:31.
 */
public class EcdsaSign {
    public static final String KEY_TYPE = "EC";
    public static final String SIGN_TYPE = "SHA1withECDSA";
    /**
     * 签名
     * @param digest
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String sign(String digest, String privateKey) throws Exception {
        byte[] keyBytes = Base64Utils.decodeFromString(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_TYPE);
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGN_TYPE);
        signature.initSign(priKey);
        signature.update(digest.getBytes());
        byte[] result = signature.sign();
        return Base64Utils.encodeToString(result);
    }

    /**
     * 验签
     * @param digest
     * @param publicKey
     * @param sign
     * @return
     * @throws Exception
     */
    public static boolean verify(String digest, String publicKey, String sign) throws Exception {
        byte[] keyBytes = Base64Utils.decodeFromString(publicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_TYPE);
        PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGN_TYPE);
        signature.initVerify(pubKey);
        signature.update(digest.getBytes());
        boolean bool = signature.verify(Base64Utils.decodeFromString(sign));
        return bool;
    }

}
