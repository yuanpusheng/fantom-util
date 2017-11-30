package com.fantom.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

//@Transactional
@ActiveProfiles(value = "test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class FantomUtilContextTests {

	@Test
	public void contextLoads() {
	}

}
