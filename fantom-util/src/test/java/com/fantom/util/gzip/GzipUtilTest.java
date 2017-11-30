package com.fantom.util.gzip;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/23 9:45.
 */
@SpringBootTest
public class GzipUtilTest {
    @Test
    public void uncompress(){
        String source = "Welcome to Bank of America, the nation's leading financial institution and home for all of your personal financial needs.";
        try {
            String str1 = GzipUitl.compress(source);
            String str2 = GzipUitl.unCompress(str1);

            Assert.assertEquals(source, str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
