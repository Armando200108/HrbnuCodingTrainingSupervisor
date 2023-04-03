package cn.pdteam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/res1")
    public String res1(){
        return "res1";
    }

    @RequestMapping("/res2")
    public String res2(){
        return "res2";
    }
}
