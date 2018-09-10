package com.tyh.code.dao2;

import com.tyh.code.pojo2.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by tyh
 * 2017-05-09 11:39
 */
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {

    List<UserInfo> findByProductStatus(Integer productStatus);

    /**
     * 使用这种方式，service里面要加 @Transactional注解
     * @param id
     * @param productStatus
     */
    @Modifying
    @Query("update UserInfo as p set p.productStatus = :productStatus where p.id = :id")
    void updateStatus(@Param(value = "id") int id, @Param(value = "productStatus") int productStatus);
}
