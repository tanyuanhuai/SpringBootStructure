package com.tyh.code.service.impl;

import com.tyh.code.dao2.UserInfoRepository;
import com.tyh.code.pojo2.UserInfo;
import com.tyh.code.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tyh.
 * 2017-05-09 17:31
 */
@Service
@Transactional("secondTransactionManager")
public class UserInfoServiceImpl implements UserInfoService {

   @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findOne(int id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public Page<UserInfo> findAll(Pageable pageable) {
        return userInfoRepository.findAll(pageable);
    }

    @Override
    public Page<UserInfo> findList(int page , int size,UserInfo userInfo) {

        // 先根据createTime状态倒序排列，再根据updateTime倒序排序，再分页。
        List<Sort.Order> orders=new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);

        Pageable pageable = new PageRequest(page, size, sort);

        Specification<UserInfo> specification = (root, query, cb) -> {

            Predicate predicate = cb.equal(root.get("id"), userInfo.getId());

            predicate = cb.and(predicate, cb.notEqual(root.get("productStock"), userInfo.getProductStock()));

            if (userInfo.getProductName() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("productName"), userInfo.getProductName()));
            }

            if (userInfo.getCreateTime() != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.<Date>get("createTime"), userInfo.getCreateTime()));
            }


            if (userInfo.getProductName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("productName"), "%" + userInfo.getProductName() + "%"));
            }

            return predicate;
        };

        Page<UserInfo> userInfoPage = userInfoRepository.findAll(specification, pageable);

        return userInfoPage;
    }

    @Override
    public UserInfo save(UserInfo UserInfo) {
        return userInfoRepository.save(UserInfo);
    }

    @Transactional
    @Override
    public void updatStatus(int id , int productStatus) {
        userInfoRepository.updateStatus(id,productStatus);
    }
}
