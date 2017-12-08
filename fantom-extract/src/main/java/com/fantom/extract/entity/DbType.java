package com.fantom.extract.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/7 17:15.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DbType extends BaseProp {
    /**
     * db Driver
     */
    private String db_driver;

    /**
     * url 前缀
     */
    private String url_prefix;
}
