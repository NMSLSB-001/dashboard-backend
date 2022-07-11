package com.example.dashboardbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String index2(){
        return "index2";
    }

}
