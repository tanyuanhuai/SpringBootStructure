/*
 * 创建 Administrator 2018-06-27 15:11
 */
package com.tyh.code.controller;

import com.tyh.code.model.Resource;
import com.tyh.code.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Person 测试Controller 。
 * <p>
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Resource类绑定了 resource.properties 文件的属性值
     */
    @Autowired
    private Resource           resource;

    /**
     * 测试 Mybatis 多数据源
     * @param map
     * @return
     */
    @RequestMapping("/p")
    public String ftl(ModelMap map) {
        System.out.println(personService.findOne().getName());
        System.out.println(personService.findTwo().getName());
        personService.testAnnotation();
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }



}
