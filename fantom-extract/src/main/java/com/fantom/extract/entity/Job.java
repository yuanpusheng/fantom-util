package com.fantom.extract.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/7 17:15.
 */
@AllArgsConstructor
@Data
public class Job extends BaseProp{
    /**
     * Source Db Id
     */
    private Integer source_type_id;
    /**
     * Target Db Id
     */
    private Integer target_type_id;
    /**
     * Source Db Conn
     */
    private String source_db_conn;
    /**
     * Target Db Conn
     */
    private String target_db_conn;
    /**
     * fromeSql Id
     */
    private Integer from_sql_id;
    /**
     * toSql Ids.
     */
    private String to_sql_ids;

}
