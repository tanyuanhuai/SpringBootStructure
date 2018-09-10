package com.tyh.code.service.impl;

import com.tyh.code.ApplicationTests;
import com.tyh.code.pojo2.UserInfo;
import com.tyh.code.service.UserInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * 创建 Administrator 2018-06-28 9:52
 */
public class UserInfoServiceImplTest extends ApplicationTests {

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void save() {
        UserInfo userInfo = new UserInfo();
        //productInfo.setId(2);
       // userInfo.setProductName("ceshi2");
        //userInfoService.save(userInfo);
    }

    @Test
    public void updatStatus() {
    }
}