package com.fantom.extract.control;

import com.fantom.extract.entity.DbType;
import com.fantom.extract.service.DbTypeService;
import com.fantom.extract.support.JsonUtil;
import com.fantom.extract.support.resp.ResponseBean;
import com.fantom.extract.support.resp.ResponseBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/8 12:50.
 */
@RequestMapping("/dbtype")
@Controller
public class DbTypeController {
    @Autowired
    DbTypeService dbTypeService;

    /**
     * Test
     *
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model) {
        System.out.println("hello");
        model.addAttribute(new DbType());
        return "/dbtype/add";
    }

    /**
     * 添加 db Type
     *
     * @return
     */
    @RequestMapping
    public String list(Model model) {
//        DbType dbType = JsonUtil.json2Obj(dbTypeStr, DbType.class);
        model.addAllAttributes(dbTypeService.list());
        return "/dbtype/list";
    }

    /**
     * 添加 db Type
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute DbType dbType) {
//        DbType dbType = JsonUtil.json2Obj(dbTypeStr, DbType.class);
        dbTypeService.update(dbType);
        return "/dbtype";
    }

    /**
     * 更新 配置文件
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseBean<Integer> updateDbType(String dbTypeStr) {
        DbType dbType = JsonUtil.json2Obj(dbTypeStr, DbType.class);
        return ResponseBeanUtil.success(dbTypeService.update(dbType));
    }


}
