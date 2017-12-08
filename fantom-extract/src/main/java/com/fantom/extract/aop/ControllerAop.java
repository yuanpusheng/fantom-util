package com.fantom.extract.aop;

import com.fantom.extract.support.resp.ResponseBean;
import com.fantom.extract.support.resp.ResponseBeanUtil;
import com.fantom.extract.support.resp.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/30 13:43.
 */
@Aspect
@Configuration
@Slf4j
public class ControllerAop {
    //匹配com.fantom.http.control包及其子包中所有类中的所有方法，返回类型任意，方法参数任意 && 被RequestMapping注解的方法
    @Pointcut("execution(* com.fantom.extract.api..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMappingMethod() {

    }

    @Around("requestMappingMethod()")
    public ResponseBean<?> handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        ResponseBean<?> result;
        try {
            result = (ResponseBean<?>) pjp.proceed();
//            统一日志处理
            log.info(pjp.getSignature() + " cost time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
//            统一异常处理
            result = handlerException(pjp, e);
        }

        return result;
    }

    private ResponseBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResponseBean<?> result = new ResponseBean();
        // 已知异常 TODO
        if (e instanceof NullPointerException) {
            result = ResponseBeanUtil.fail(ResultEnum.SERVER_ERROR);
        } else {
            log.error(pjp.getSignature() + " error ", e);
            result = ResponseBeanUtil.exception(e);
            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }

        return result;
    }
}
