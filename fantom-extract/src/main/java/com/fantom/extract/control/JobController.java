package com.fantom.extract.control;

import com.fantom.extract.entity.Job;
import com.fantom.extract.service.JobService;
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
@RequestMapping("/job")
@Controller
public class JobController {
    @Autowired
    JobService jobService;

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
     * 添加 配置文件
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseBean<Integer> saveJob(String jobConfigStr){
        Job jobConfig = JsonUtil.json2Obj(jobConfigStr, Job.class);
        return ResponseBeanUtil.success(jobService.update(jobConfig));
    }

    /**
     * 更新 配置文件
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseBean<Integer> updateJob(String jobConfigStr){
        Job jobConfig = JsonUtil.json2Obj(jobConfigStr, Job.class);
        return ResponseBeanUtil.success(jobService.update(jobConfig));
    }

    /**
     * 运行Job
     * @return
     */
    @RequestMapping("/execute/{jobId}")
    public ResponseBean<Integer> executeJob(@PathVariable Integer jobId){
        return ResponseBeanUtil.success(jobService.execute(jobId));
    }

    /**
     * 开启/关闭Job 定时任务
     * @return
     */
    @RequestMapping("/toggle/{jobId}")
    public ResponseBean<Integer> toggleJobPlan(@PathVariable Integer jobId){
        return ResponseBeanUtil.success(jobService.toggle(jobId));
    }
}
