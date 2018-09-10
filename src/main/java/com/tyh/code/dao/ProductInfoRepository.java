package com.tyh.code.dao;

import com.tyh.code.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by tyh
 * 2017-05-09 11:39
 *
 */
public interface ProductInfoRepository extends PagingAndSortingRepository<ProductInfo, Integer>, JpaSpecificationExecutor<ProductInfo> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    /**
     * 使用这种方式，service里面要加 @Transactional注解
     * @param id
     * @param productStatus
     */
    @Modifying
    @Query("update ProductInfo as p set p.productStatus = :productStatus where p.id = :id")
    void updateStatus(@Param(value = "id") int id, @Param(value = "productStatus") int productStatus);


}
