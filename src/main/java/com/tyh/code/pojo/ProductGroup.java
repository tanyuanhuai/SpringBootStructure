/*
 * 创建 tyh 2018-09-10 10:44
 */
package com.tyh.code.pojo;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 描述:
 * 商品分组，一个商品只能属于一个组，一个组里可以有多个商品。
 *
 * @author tyh
 * @create 2018-09-10 10:44
 */
@Entity
@Table(name = "product_group")
@DynamicUpdate
public class ProductGroup {

    /**
     * 组id
     */
    private String  id;
    /**
     * 组名称
     */
    private String name;

    @Id
    //此种主键生成策略就是通常所说的主键自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
