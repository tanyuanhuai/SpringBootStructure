package com.tyh.code.service.impl;

import com.tyh.code.ApplicationTests;
import com.tyh.code.pojo.ProductGroup;
import com.tyh.code.pojo.ProductInfo;
import com.tyh.code.service.ProductInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/*
 * 创建 Administrator 2018-06-27 14:44
 */
public class ProductInfoServiceImplTest extends ApplicationTests{

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne(1);
        System.out.println(productInfo.getProductName());
    }

    @Test
    public void findAll() {

    }


    /**
     * 测试分页、条件、排序 查询
     */
    @Test
    public void findList() {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId("1");
        productGroup.setName("1");
        Page<ProductInfo> productInfoPage = productInfoService.findList(1,1,new ProductInfo(),productGroup);

        System.out.println(productInfoPage.getTotalPages());
    }

    @Test
    public void save() {
        //ProductInfo productInfo = new ProductInfo();
        //productInfo.setId(2);
        //productInfo.setProductName("ceshi2");
        //productService.save(productInfo);
    }
    @Test
    public void updateStatus() {
        productInfoService.updatStatus(1,222);
    }

    @Test
    public void sendWebSocket() {
        productInfoService.sendWebSocket();
    }
}