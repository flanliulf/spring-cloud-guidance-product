package com.fancyliu.springcloud.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        String message = "this is product's message.";
        log.info(message);
        return message;
    }
}
