package com.fantom.extract.api;

import com.fantom.extract.entity.SqlUnit;
import com.fantom.extract.service.SqlUnitService;
import com.fantom.extract.service.SqlUnitService;
import com.fantom.extract.support.JsonUtil;
import com.fantom.extract.support.resp.ResponseBean;
import com.fantom.extract.support.resp.ResponseBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/8 12:50.
 */
@RequestMapping("/api/sql")
@RestController
public class SqlUnitApi {
    @Autowired
    SqlUnitService sqlUnitService;

    /**
     * db Type list
     * @return
     */
    @RequestMapping
    public ResponseBean<List<Map<String, Object>>> list(){
        return ResponseBeanUtil.success(sqlUnitService.list());
    }

    /**
     * 添加 db Type
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseBean<Integer> save(@RequestParam String sqlUnitStr){
        SqlUnit sqlUnit = JsonUtil.json2Obj(sqlUnitStr, SqlUnit.class);
        return ResponseBeanUtil.success(sqlUnitService.update(sqlUnit));
    }

    /**
     * 更新 配置文件
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseBean<Integer> updateSqlUnit(String sqlUnitStr){
        SqlUnit sqlUnit = JsonUtil.json2Obj(sqlUnitStr, SqlUnit.class);
        return ResponseBeanUtil.success(sqlUnitService.update(sqlUnit));
    }


}
