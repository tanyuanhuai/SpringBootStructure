/*
 * 创建 Administrator 2018-06-27 15:11
 */
package com.tyh.code.controller;

import com.tyh.code.model.Resource;
import com.tyh.code.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 。
 * <p>
 */
@Controller
@RequestMapping("/product")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * Resource类绑定了 resource.properties 文件的属性值
     */
    @Autowired
    private Resource           resource;

    /**
     * 测试 freemarker
     * @param map
     * @return
     */
    @RequestMapping("/ftl")
    public String ftl(ModelMap map) {
        System.out.println(productInfoService.findOne(1).getProductName());
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    /**
     * 测试 thymeleaf
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap map) {
        // 测试 发送websocket
        // productInfoService.sendWebSocket();
        map.addAttribute("resource", resource);
        return "thymeleaf/index";
    }
    /**
     * 测试 websocket
     * @return
     */
    @RequestMapping("/websocket")
    public String websocket() {
        return "websocket";
    }

}
