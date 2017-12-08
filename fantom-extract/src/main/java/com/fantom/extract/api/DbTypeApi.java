package com.fantom.extract.api;

import com.fantom.extract.entity.DbType;
import com.fantom.extract.service.DbTypeService;
import com.fantom.extract.support.JsonUtil;
import com.fantom.extract.support.resp.ResponseBean;
import com.fantom.extract.support.resp.ResponseBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/8 12:50.
 */
@RequestMapping("/api/dbtype")
@RestController
public class DbTypeApi {
    @Autowired
    DbTypeService dbTypeService;

    /**
     * Test
     * @return
     */
    @RequestMapping("/add")
    public String hello(@PathVariable String some){
        return "/dbtype/add";
    }

    /**
     * db Type list
     * @return
     */
    @RequestMapping
    public ResponseBean<List<Map<String, Object>>> list(){
        return ResponseBeanUtil.success(dbTypeService.list());
    }

    /**
     * 添加 db Type
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseBean<Integer> save(@RequestParam String dbTypeStr){
        DbType dbType = JsonUtil.json2Obj(dbTypeStr, DbType.class);
        return ResponseBeanUtil.success(dbTypeService.update(dbType));
    }

    /**
     * 更新 配置文件
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseBean<Integer> updateDbType(String dbTypeStr){
        DbType dbType = JsonUtil.json2Obj(dbTypeStr, DbType.class);
        return ResponseBeanUtil.success(dbTypeService.update(dbType));
    }


}
