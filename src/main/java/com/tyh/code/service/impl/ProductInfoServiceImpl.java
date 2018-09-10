package com.tyh.code.service.impl;

import com.tyh.code.dao.ProductInfoRepository;
import com.tyh.code.pojo.ProductGroup;
import com.tyh.code.pojo.ProductInfo;
import com.tyh.code.service.ProductInfoService;
import com.tyh.code.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tyh.
 * 2017-05-09 17:31
 */
@Service
@Transactional("firstTransactionManager")
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private WebSocket     webSocket;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductInfo findOne(int id) {
        return productInfoRepository.findOne(id);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public Page<ProductInfo> findList(int page , int size, ProductInfo productInfo, ProductGroup productGroup) {
        List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();

        // 先根据createTime状态倒序排列，再根据updateTime倒序排序，再分页。
        List<Sort.Order> orders=new ArrayList<Sort.Order>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);

        Pageable pageable = new PageRequest(page, size, sort);

        Specification<ProductInfo> specification = (root, query, cb) -> {

            Predicate predicate = cb.equal(root.get("id"), productInfo.getId());

            predicate = cb.and(predicate, cb.notEqual(root.get("productStock"), productInfo.getProductStock()));

            if (productInfo.getProductName() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("productName"), productInfo.getProductName()));
            }

            if (productInfo.getCreateTime() != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.<Date>get("createTime"), productInfo.getCreateTime()));
            }


            if (productInfo.getProductName() != null) {
                predicate = cb.and(predicate, cb.like(root.get("productName"), "%" + productInfo.getProductName() + "%"));
            }

            if(productGroup.getName()!=null) {
                Path<String> orgnamepath=root.get("productGroup").get("name");
                predicate = cb.like(orgnamepath,"%"+productGroup.getName()+"%");
            }
            return predicate;
        };

        Page<ProductInfo> productInfoPage = productInfoRepository.findAll(specification, pageable);

        return productInfoPage;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Transactional
    @Override
    public void updatStatus(int id , int productStatus) {
        productInfoRepository.updateStatus(id,productStatus);
    }

    @Override
    public void sendWebSocket() {
        webSocket.sendMessage("测试发送");
    }

}
