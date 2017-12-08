package com.fantom.extract.support.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/11/29 17:01.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseBean<P> {
    private String code = "0";
    private String message = "成功";
    private P p = null;

    public ResponseBean(P p) {
        this.p = p;
    }

    public ResponseBean(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
