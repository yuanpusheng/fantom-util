package com.fantom.util;

import com.fantom.util.beans.BeanMapUtilTest;
import com.fantom.util.gzip.GzipUtilTest;
import com.fantom.util.sign.RsaSignTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

//@Transactional
@ActiveProfiles(value = "test")
@RunWith(Suite.class)
@Suite.SuiteClasses({BeanMapUtilTest.class, GzipUtilTest.class, RsaSignTest.class})
@SpringBootTest
public class FantomUtilSimpleTests {

	@Test
	public void contextLoads() {
	}

}
