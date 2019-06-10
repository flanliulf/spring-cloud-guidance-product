package com.fancyliu.springcloud.product.vo;

public class ResponseDataUtils {

    public static ResponseData success(Integer code, String msg, Object data) {
        return new ResponseData(true, code, msg, data);
    }
}
