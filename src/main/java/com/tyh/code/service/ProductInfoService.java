package com.tyh.code.service;

import com.tyh.code.pojo.ProductGroup;
import com.tyh.code.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 商品
 * Created by
 * 2017-05-09 17:27
 */
public interface ProductInfoService {

    ProductInfo findOne(int id);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 按照查询条件分页查询
     * @param page  当前页
     * @param size  每页显示多少条
     * @return
     */
    Page<ProductInfo> findList(int page, int size, ProductInfo productInfo,ProductGroup productGroup);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 更新操作
     * @param id
     * @param productStatus
     */
    public void updatStatus(int id, int productStatus);

    void sendWebSocket();

}
