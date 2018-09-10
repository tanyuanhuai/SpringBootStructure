package com.tyh.code.service;

import com.tyh.code.pojo2.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户
 * Created by
 * 2017-05-09 17:27
 */
public interface UserInfoService {

    UserInfo findOne(int id);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<UserInfo> findAll(Pageable pageable);

    /**
     * 按照查询条件分页查询
     * @param page  当前页
     * @param size  每页显示多少条
     * @return
     */
    Page<UserInfo> findList(int page, int size, UserInfo userInfo);

    UserInfo save(UserInfo userInfo);

    /**
     * 更新操作
     * @param id
     * @param productStatus
     */
    public void updatStatus(int id, int productStatus);

}
