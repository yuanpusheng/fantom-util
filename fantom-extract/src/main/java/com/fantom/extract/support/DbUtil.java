package com.fantom.extract.support;

import com.fantom.extract.entity.DbConn;
import com.fantom.extract.entity.DbType;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/7 18:40.
 */
public class DbUtil {
    public static PoolProperties genPoolProperties(DbType dbType, DbConn dbConn) {
        PoolProperties result = new PoolProperties();
        result.setUsername(dbConn.getUsername());
        result.setPassword(dbConn.getPassword());
        StringBuilder sb = new StringBuilder(dbType.getUrl_prefix());
        String url = sb.append(dbConn.getHost()).append(":").append(dbConn.getPort()).append("/").append(dbConn.getDb_name()).toString();
        result.setUrl(url);
        result.setDriverClassName(dbType.getDb_driver());
        return result;
    }

    public static JdbcTemplate genJdbcTemplate(DbType dbType, DbConn dbConn){
        return new JdbcTemplate(new DataSource(genPoolProperties(dbType, dbConn)));
    }
}
