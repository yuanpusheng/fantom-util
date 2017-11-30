package com.fantom.util.sign;

import com.fantom.util.encipher.keypair.KeyPairUtil;
import com.fantom.util.sign.core.RsaSign;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/22 16:21.
 */
@SpringBootTest
public class RsaSignTest {
    @Test
    public void verify() {
        try {
            KeyPair keyPair = KeyPairUtil.genKeyPair("RSA", 1024);
            String digest = "hello";
            String sign = RsaSign.sign(digest, KeyPairUtil.getPrivateKey(keyPair));
            boolean flag = RsaSign.verify(digest, KeyPairUtil.getPublicKey(keyPair), sign);

            Assert.assertTrue("Rsa验签失败!", flag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
