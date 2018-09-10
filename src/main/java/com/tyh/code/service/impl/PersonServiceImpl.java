/*
 * 创建 tyh 2018-07-16 15:51
 */
package com.tyh.code.service.impl;

import com.tyh.code.mapper.OnePersonMapper;
import com.tyh.code.mapper2.TwoPersonMapper;
import com.tyh.code.pojo.Person;
import com.tyh.code.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * Person测试业务类。
 *
 * @author tyh
 * @create 2018-07-16 15:51
 */
@Service
public class PersonServiceImpl implements PersonService {

    /**
     * 数据源 1
     */
    @Autowired
    OnePersonMapper onePersonMapper;

    /**
     * 数据源 2
     */
    @Autowired
    TwoPersonMapper twoPersonMapper;

    @Override
    public Person findOne() {

        return onePersonMapper.selectByPrimaryKey(1);
    }

    @Override
    public Person findTwo() {
        return twoPersonMapper.selectByPrimaryKey(1);
    }

    @Override
    public void testAnnotation() {
        Person person = onePersonMapper.getByName("1");
        System.out.println("--------"+person.getName());
        Person person1 = new Person();
        person1.setId(22);
        person1.setName("22");
        int i = twoPersonMapper.insertPerson(person1);
        System.out.println(i);
    }
}
