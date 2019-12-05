package com.fancyliu.springcloud.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 类描述:
 * 商品分类实体类
 *
 * @author : Liu Fan
 * @date : 2019-06-17 17:31
 */
@Data
@TableName("product_category")
public class ProductCategory {

    @TableId("category_id")
    private Integer categoryId;

    /** 类目名字. */
    @TableField("category_name")
    private String categoryName;

    /** 类目编号. */
    @TableField("category_type")
    private Integer categoryType;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
