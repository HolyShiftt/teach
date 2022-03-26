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

    @RequestMapping("/courseOper")
    public String courseOper(){
        return "operation/courseOper";
    }

    @RequestMapping("/updateUser")
    public String updateUser(){
        return "operation/personalOper";
    }

    @RequestMapping("/notice")
    public String notice(){
        return "notice";
    }

    @RequestMapping("/noticeOper")
    public String noticeOper(){
        return "operation/noticeOper";
    }

    @RequestMapping("/question")
    public String question(){
        return "exam/question";
    }

    @RequestMapping("/examTeacher")
    public String examTeacher(){
        return "exam/examTeacher";
    }

    @RequestMapping("/questionradioOper")
    public String questionRadioOper(){
        return "operation/questionRadioOper";
    }

    @RequestMapping("/questiontellOper")
    public String questionTellOper(){
        return "operation/questionTellOper";
    }

    @RequestMapping("/questiontextOper")
    public String questionTextOper(){
        return "operation/questionTextOper";
    }

    @RequestMapping("/myExamTeacher")
    public String myExamTeacher(){
        return "exam/myExamTeacher";
    }

    @RequestMapping("/examStudent")
    public String examStudent(){
        return "exam/examStudent";
    }

    @RequestMapping("/doExam")
    public String doExam(Integer id,HttpSession session){
        session.setAttribute("examId",id);
        return "exam/doExam";
    }

    @RequestMapping("/myExamStu")
    public String myExamStu(){
        return "exam/myExamStu";
    }
}
