package com.fantom.http.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/23 18:01.
 */
@Data
public class JobConfig {
    protected String name;
    protected String description;
    protected String sourceDb;
    protected String targetDb;
    /**
     * 时间过滤参数
     */
    protected String timeFilter;
    protected SqlInfo fromSql;
    protected List<SqlInfo> toSqls = new ArrayList<>();
}
