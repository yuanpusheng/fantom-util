package com.fantom.extract.control;

import com.fantom.extract.entity.DbConn;
import com.fantom.extract.service.DbConnService;
import com.fantom.extract.support.JsonUtil;
import com.fantom.extract.support.resp.ResponseBean;
import com.fantom.extract.support.resp.ResponseBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/8 12:50.
 */
@RequestMapping("/dbconn")
@Controller
public class DbConnController {
    @Autowired
    DbConnService dbConnService;

    /**
     * Test
     * @return
     */
    @RequestMapping("/hello/{some}")
    public ResponseBean hello(@PathVariable String some){
        ResponseBean result = ResponseBeanUtil.success();
        result.setMessage("hello" + some);
        return result;
    }

    /**
     * 添加 db Conn
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseBean<Integer> saveDbConn(String dbConnStr){
        DbConn dbConn = JsonUtil.json2Obj(dbConnStr, DbConn.class);
        return ResponseBeanUtil.success(dbConnService.update(dbConn));
    }

    /**
     * 更新 配置文件
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseBean<Integer> updateDbConn(String dbConnStr){
        DbConn dbConn = JsonUtil.json2Obj(dbConnStr, DbConn.class);
        return ResponseBeanUtil.success(dbConnService.update(dbConn));
    }


}
