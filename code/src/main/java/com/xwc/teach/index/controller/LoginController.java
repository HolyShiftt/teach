package com.xwc.teach.index.controller;

import com.xwc.teach.AjaxRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String toPage() {
        return "/login";
    }
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public AjaxRes login(@RequestParam(value="username",required=false)String username, @RequestParam(value="password",required=false)String password) {
        System.out.println(username);
        AjaxRes ajaxRes = new AjaxRes();
        ajaxRes.setSuccess(true);
        ajaxRes.setMsg("success");
        return ajaxRes;
    }
}
