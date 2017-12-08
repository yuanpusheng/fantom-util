package com.fantom.extract.service;

import com.fantom.extract.entity.Job;
import com.fantom.extract.support.JsonUtil;
import com.fantom.extract.support.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/30 9:53.
 */
@Service
public class JobService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer update(Job jobConfig) {
        Map<String, ?> params = BeanMap.create(jobConfig);
        params.entrySet().stream().filter(entry -> !ObjectUtils.isEmpty(entry.getValue()));
        String preSql = SqlUtil.genInsertPreSql("job", params);
        return namedParameterJdbcTemplate.update(preSql, new BeanPropertySqlParameterSource(jobConfig));
    }

    public Integer execute(Integer jobId) {
        String targetUrl = "";
        Map map = new HashMap();
        map.put("jobId", jobId);
        String preSql = "select * from job where id = :jobId";
        Job jobConfig = namedParameterJdbcTemplate.queryForObject(preSql, map, Job.class);
        String params = "jobConfig="+ JsonUtil.obj2Json(jobConfig);
//        String result = HttpSender.post(targetUrl, params);
        return 1;
    }

    public Integer toggle(Integer jobId) {
        return 1;
    }
}
