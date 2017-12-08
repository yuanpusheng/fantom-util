package com.fantom.extract.entity;

import lombok.Data;

/**
 * @author tufatao
 * @version V 0.1
 * @describe {}
 * @time 2017/12/8 13:45.
 */
@Data
public class BaseProp {
    protected Integer id;
    /**
     * 名称
     */
    protected String name;
    /**
     * 描述
     */
    protected String description;
}
