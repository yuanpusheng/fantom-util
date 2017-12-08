package com.fantom.extract.service;

import com.fantom.extract.entity.DbType;
import com.fantom.extract.entity.Job;
import com.fantom.extract.support.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/30 9:53.
 */
@Service
public class DbTypeService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer update(DbType dbType) {
        Integer result = jdbcTemplate.update("INSERT INTO db_type(name, description, db_driver, url_prefix) VALUES (?,?,?,?)"
                , dbType.getName(), dbType.getDescription(), dbType.getDb_driver(), dbType.getUrl_prefix());
//        Map<String, ?> params = BeanMap.create(dbType);
//        params.entrySet().stream().filter(entry -> !ObjectUtils.isEmpty(entry.getValue()));
//        String preSql = SqlUtil.genInsertPreSql("db_type", params);
//        return namedParameterJdbcTemplate.update(preSql, new BeanPropertySqlParameterSource(params));
        return result;
    }

    public List<Map<String, Object>> list() {
        String preSql = "SELECT * FROM db_type";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(preSql);
        return list;
    }

    public Integer execute(Integer jobId) {
        String targetUrl = "";
        Map map = new HashMap();
        map.put("jobId", jobId);
        String preSql = "select * from job_config where id = :jobId";
        Job jobConfig = namedParameterJdbcTemplate.queryForObject(preSql, map, Job.class);
        String params = "jobConfig="+ JsonUtil.obj2Json(jobConfig);
//        String result = HttpSender.post(targetUrl, params);
        return 1;
    }

    public Integer toggle(Integer jobId) {
        return 1;
    }
}
