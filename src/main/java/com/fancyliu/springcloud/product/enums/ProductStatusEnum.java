package com.fancyliu.springcloud.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    /**
     * 在售商品状态
     */
    UP(0, "在架"),

    /**
     * 下架商品状态
     */
    DOWN(1, "下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
