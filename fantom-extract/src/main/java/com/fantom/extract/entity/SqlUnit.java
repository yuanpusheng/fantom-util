package com.fantom.extract.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/24 14:39.
 */
@AllArgsConstructor
@Data
public class SqlUnit extends BaseProp {
    /**
     * sql语句
     */
    private String sqn;
    /**
     * 时间过滤字段
     */
    private String time_filter;
}
