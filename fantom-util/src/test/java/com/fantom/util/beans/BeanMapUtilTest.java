package com.fantom.util.beans;

import com.fantom.util.beans.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/22 9:58.
 */
@SpringBootTest
public class BeanMapUtilTest {
    @Test
    public void map2Bean(){
        Map<String, Object> source = new HashMap<>();
        String name = "Bobo";
        source.put("name", name);
        source.put("sex", 0);
        User user = new User();

        BeanMapUtil.map2Bean(source, user);
        Assert.isTrue(name.equals(user.getName()), "map2Bean 转化失败");
    }

    @Test
    public void bean2Map(){
        String name = "Bobo";
        User user = new User();
        user.setName(name);
        user.setSex(0);

        Map<String, ?> source = BeanMapUtil.bean2Map(user);
        Assert.isTrue(name.equals(source.get("name")), "bean2Map 转化失败");
    }
}
