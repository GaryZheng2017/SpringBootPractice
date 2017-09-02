package cn.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web-springboot")
public class Hello {
    @RequestMapping("/test.do")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/hello.do")
    public String index1() {
        return "index";
    }   
    
}
