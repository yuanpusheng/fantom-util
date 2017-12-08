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
public class DbConn extends BaseProp {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * Host
     */
    private String host;
    /**
     * 端口
     */
    private String port;
    /**
     * 数据库
     */
    private String db_name;

}
