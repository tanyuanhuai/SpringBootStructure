package com.tyh.code.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tyh.code.enums.ProductStatusEnum;
import com.tyh.code.utils.EnumUtil;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 信息
 * Created by tyh
 * 2018-05-09 11:30
 */
@Entity
@Table(name = "product_info")
@DynamicUpdate
public class ProductInfo {


     /*
        //GenerationType.SEQUENCE
        叫做"序列(sequence)"的机制生成主键
        @GeneratedValue(generator = "logbookTemplate")
        @GenericGenerator(name = "logbookTemplate", strategy = "uuid")
        @Id
        @Column(name = "ID")
     */

    @Id
    //此种主键生成策略就是通常所说的主键自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * 名字
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 所属组
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private ProductGroup productGroup;

    /**
     * 单价
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @Column(name = "product_stock")
    private Integer productStock;

    /**
     * 描述
     */
    @Column(name = "product_description")
    private String productDescription;

    /**
     * 小图
     */
    @Column(name = "product_icon")
    private String productIcon;

    /**
     * 状态, 0正常1下架.
     */
    @Column(name = "product_status")
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**
     * 类目编号
     */
    @Column(name = "category_type")
    private Integer categoryType;
    /**
     * 创建日期
     */
    @Column(name = "category_time")
    private Date createTime;
    /**
     * 更新日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}
