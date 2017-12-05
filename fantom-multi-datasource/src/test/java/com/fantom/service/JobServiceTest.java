package com.fantom.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/5 15:31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobServiceTest {
    @Autowired
    JobService jobService;
    @Test
    public void countJob(){
        Integer result = jobService.countJob();
        System.out.println("countJob: " + result);
    }

    @Test
    @Transactional //开启事务管理
    @Rollback //自动回滚
    public void addCategory(){
        Integer result = jobService.addCategory();
        System.out.println("addCategory: " + result);
    }
}
