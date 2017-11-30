package com.fantom.http.control;

import com.fantom.http.entity.JobConfig;
import com.fantom.http.service.TransformJobService;
import com.fantom.http.support.JsonUtil;
import com.fantom.http.support.resp.ResponseBean;
import com.fantom.http.support.resp.ResponseBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/30 9:43.
 */
@RestController
@RequestMapping("/jobs")
public class TransformJobController {
    @Autowired
    TransformJobService transformJobService;

    /**
     * 添加 配置文件
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseBean<Integer> saveJobConfig(String jobConfigStr){
        JobConfig jobConfig = JsonUtil.json2Obj(jobConfigStr, JobConfig.class);
        return ResponseBeanUtil.success(transformJobService.update(jobConfig));
    }

    /**
     * 更新 配置文件
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseBean<Integer> updateJobConfig(String jobConfigStr){
        JobConfig jobConfig = JsonUtil.json2Obj(jobConfigStr, JobConfig.class);
        return ResponseBeanUtil.success(transformJobService.update(jobConfig));
    }

    /**
     * 运行Job
     * @return
     */
    @RequestMapping("/execute/{jobId}")
    public ResponseBean<Integer> executeJob(@PathVariable Integer jobId){
        return ResponseBeanUtil.success(transformJobService.execute(jobId));
    }

    /**
     * 开启/关闭Job 定时任务
     * @return
     */
    @RequestMapping("/toggle/{jobId}")
    public ResponseBean<Integer> toggleJobPlan(@PathVariable Integer jobId){
        return ResponseBeanUtil.success(transformJobService.toggle(jobId));
    }
}
