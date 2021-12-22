package com.xwc.teach.index.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xwc.teach.commons.Pages;
import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.index.entity.User;
import com.xwc.teach.index.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/stuInfo")
    @ResponseBody
    public Result personalInfo(String username){
        Result result = new Result();
        User userByUsername = userService.getByUsername(username, 3);
        result.setCode(1);
        result.setMsg(userByUsername);
        return result;
    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public Result updatePwd(Integer id, String password,String oldPwd){
        Result result = new Result();
        String oldPassword = userService.getUserById(id).getPassword();
        if (!oldPwd.equals(oldPassword)){
            result.setCode(0);
            result.setMsg("原密码错误");
        }else if(password.equals(oldPassword)){
            result.setCode(0);
            result.setMsg("新旧密码不能一致");
        } else{
            int success = userService.updatePwd(id, password);
            if (success==1){
                result.setCode(1);
                result.setMsg("密码修改成功");
            }else{
                result.setCode(0);
                result.setMsg("密码修改失败");
            }
        }
        return result;
    }

    @RequestMapping("/userList")
    @ResponseBody
    public Table userList(Pages pages,Integer role,String name){
        Page<?> page = PageHelper.startPage(pages.getPage(), pages.getLimit());
        List<User> users = userService.selectAll(role,name);
        return Table.success(Long.valueOf(page.getTotal()),users);
    }

}
