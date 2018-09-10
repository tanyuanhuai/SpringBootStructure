/*
 * 创建 tyh 2018-07-16 15:49
 */
package com.tyh.code.service;

import com.tyh.code.pojo.Person;

/**
 * 描述:
 * Person测试业务类。
 *
 * @author tyh
 * @create 2018-07-16 15:49
 */
public interface PersonService {

    /**
     * 查询 数据源 1
     */
    Person findOne();

    /**
     * 查询 数据源 2
     */
    Person findTwo();

    void testAnnotation();
}
