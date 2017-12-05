package com.fantom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/5 15:23.
 */
@Service
public class JobService {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate secondaryJdbcTemplate;

    public Integer countJob(){
        Integer result = primaryJdbcTemplate.queryForObject("select count(*) from book", Integer.class);
        return result;
    }

    public Integer addCategory(){
        Integer result = secondaryJdbcTemplate.update("INSERT INTO category(name, description) VALUES (?, ?)", "Code", "Code Something");
        return result;
    }
}
