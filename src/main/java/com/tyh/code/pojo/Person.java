/*
 * 创建 tyh 2018-07-16 15:22
 */
package com.tyh.code.pojo;

import java.io.Serializable;

/**
 * 描述:
 * 用户测试类。
 *
 * @author tyh
 * @create 2018-07-16 15:22
 */
public class Person implements Serializable {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
