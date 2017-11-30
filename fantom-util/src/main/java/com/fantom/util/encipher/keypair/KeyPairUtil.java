package com.fantom.util.encipher.keypair;

import org.springframework.util.Base64Utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/22 14:28.
 */
public class KeyPairUtil {
    /**
     * 生成密钥对
     * @param encryptType
     * @param keySize
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair genKeyPair(String encryptType, int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(encryptType);
        keyPairGenerator.initialize(keySize);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    /**
     * 获取String类型的 privateKey
     * @param keyPair
     * @return
     */
    public static String getPrivateKey(KeyPair keyPair){
        return Base64Utils.encodeToString(keyPair.getPrivate().getEncoded());
    }

    /**
     * 获取String类型的 publicKey
     * @param keyPair
     * @return
     */
    public static String getPublicKey(KeyPair keyPair){
        return Base64Utils.encodeToString(keyPair.getPublic().getEncoded());
    }
}
