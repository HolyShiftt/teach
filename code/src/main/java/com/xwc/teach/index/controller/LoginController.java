package com.xwc.teach.index.controller;

import com.xwc.teach.commons.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String page(HttpSession session) {
        if (null != session.getAttribute("username")){
            return "/index";
        }else{
            return "/login";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestParam(value="username",required=false)String username
            , @RequestParam(value="password",required=false)String password, HttpSession session) {
        Result result = new Result();
        session.setAttribute("username",username);
        result.setCode(1);
        result.setMsg("success");
        return result;
    }

    @RequestMapping("/out")
    @ResponseBody
    public Result login(HttpSession session) {
        Result result = new Result();
        if (session != null) {
            session.invalidate();//清除session
        }
        result.setCode(1);
        result.setMsg("退出登录成功！");
        return result;
    }
}
