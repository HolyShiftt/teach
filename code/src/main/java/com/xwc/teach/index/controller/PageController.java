package com.xwc.teach.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @RequestMapping("/")
    public String page(HttpSession session) {
        if (null != session.getAttribute("user")){
            return "/index";
        }else{
            return "/login";
        }
    }

    @RequestMapping("/personal")
    public String personal(){
        return "personal";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(){
        return "updatePwd";
    }

}