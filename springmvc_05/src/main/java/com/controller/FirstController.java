package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/test")
    public String test(){
       /* String s  = null;
        s.charAt(1);*/
        return "note";
    }
}
