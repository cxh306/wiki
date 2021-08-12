package com.cxh.wiki.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    //"http://127.0.0.1:8080/hello"

    /**
     * GET,POST,PUT,DELETE
     *
     * /user?id=1
     * /user/1
     * @return
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
}
