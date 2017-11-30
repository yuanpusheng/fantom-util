package com.fantom.http.support.resp;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/29 17:10.
 */
public class ResponseBeanUtil {
    /**
     * 正常返回(无data)
     * @return
     */
    public static ResponseBean success(){
        return new ResponseBean();
    }

    /**
     * 正常返回
     * @param p
     * @param <P>
     * @return
     */
    public static <P> ResponseBean<P> success(P p){
        return new ResponseBean(p);
    }


    /**
     * 捕获错误返回(无data)
     * @param resultEnum
     * @return
     */
    public static ResponseBean fail(ResultEnum resultEnum){
        return new ResponseBean(resultEnum.getCode(), resultEnum.getMessage());
    }

    /**
     * 未知异常返回(data 是 异常信息)
     * @param e
     * @return
     */
    public static ResponseBean<Exception> exception(Throwable e){
        return new ResponseBean(ResultEnum.UNKNOWN_FAIL.getCode(), ResultEnum.UNKNOWN_FAIL.getMessage(), e);
    }
}
