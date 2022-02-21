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
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/personal")
    public String personal(){
        return "personal";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping("/userOper")
    public String userOper(){
        return "operation/userOper";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(){
        return "operation/updatePwd";
    }

    @RequestMapping("/chat")
    public String chat(){
        return "chat";
    }

    @RequestMapping("/course")
    public String course(){
        return "course";
    }

    @RequestMapping("/updateUser")
    public String updateUser(){
        return "operation/personalOper";
    }

    @RequestMapping("/notice")
    public String notice(){
        return "notice";
    }

    @RequestMapping("/exam")
    public String exam(){
        return "exam/exam";
    }

    @RequestMapping("/examTeacher")
    public String examTeacher(){
        return "examInfo";
    }

    @RequestMapping("/examOper")
    public String examOper(){
        return "operation/examOper";
    }
}
