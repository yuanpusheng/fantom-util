package com.fantom.http.service;

import com.fantom.http.entity.JobConfig;
import com.fantom.http.support.SqlUtil;
import com.fantom.http.support.resp.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/30 9:53.
 */
@Service
public class TransformJobService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer update(JobConfig jobConfig) {
        Map<String, ?> params = BeanMap.create(jobConfig);
        params.entrySet().stream().filter(entry -> !ObjectUtils.isEmpty(entry.getValue()));
        String preSql = SqlUtil.genInsertPreSql("job_config", params);
        return namedParameterJdbcTemplate.update(preSql, new BeanPropertySqlParameterSource(jobConfig));
    }

    public Integer execute(Integer jobId) {
        return 1;
    }

    public Integer toggle(Integer jobId) {
        return 1;
    }
}
