package com.xwc.teach.index.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.index.entity.Student;
import com.xwc.teach.index.entity.Teacher;
import com.xwc.teach.index.entity.User;
import com.xwc.teach.index.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Login")
    @ResponseBody
    public Result login(@RequestParam(value="username")String username
            , @RequestParam(value="password")String password,@RequestParam(value="role")Integer role, HttpSession session) {
        Result result = new Result();
        User user = userService.getByUsername(username,role);
        if (null == user){
            result.setCode(0);
            result.setMsg("用户名不存在");
        } else if (password.equals(user.getPassword())){
            if (role == 3){
                Student stuClass = userService.getStuClass(user.getId());
                user.setStudent(stuClass);
            }else if(role == 2){
                Teacher teacherSubject = userService.getTeacherSubject(user.getId());
                user.setTeacherSubject(teacherSubject.getSubject());
            }else if(role == 4){
                User u = userService.getChild(user.getId());
                user.setChildren(u);
            }
            session.setAttribute("user",user);
            result.setCode(1);
            result.setMsg(user);
        }else{
            result.setCode(0);
            result.setMsg("密码错误");
        }
        return result;
    }

    @RequestMapping("/out")
    @ResponseBody
    public Result logOut(HttpSession session) {
        Result result = new Result();
        if (session != null) {
            session.invalidate();//清除session
        }
        result.setCode(1);
        result.setMsg("退出登录成功！");
        return result;
    }
}
