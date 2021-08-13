package com.cxh.wiki.controller;

import com.cxh.wiki.domain.Test;
import com.cxh.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    //"http://127.0.0.1:8080/hello"
    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;
    /**
     * GET,POST,PUT,DELETE
     **
     * /user?id=1
     * /user/1
     */
//    @GetMapping("/hello")
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
//    @RequestMapping(value = "/user/1",method = RequestMethod.GET)
//    @RequestMapping(value = "/user/1",method = RequestMethod.DELETE)
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/hello/post")
    public String hello(String name){
        return "Hello World! Post, " + name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
