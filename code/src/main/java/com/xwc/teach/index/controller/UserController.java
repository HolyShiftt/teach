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

    @RequestMapping("/personalInfo")
    @ResponseBody
    public Result personalInfo(String username,Integer role){
        Result result = new Result();
        User userByUsername = userService.getByUsername(username, role);
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

    @RequestMapping("/userAdd")
    @ResponseBody
    public Result userAdd(User user){
        Result result = new Result();
        // 判断是否存在同一角色同一用户名
        User byUsername = userService.getByUsername(user.getUsername(), user.getRole());
        if (byUsername == null){
            int code = userService.userAdd(user);
            result.setCode(code);
            if (code == 1){
                result.setMsg("添加成功");
            }else{
                result.setMsg("添加失败");
            }
        }else{
            result.setCode(0);
            result.setMsg("同一角色用户名重复");
        }
        return result;
    }

    @RequestMapping("/userDel")
    @ResponseBody
    public Result userDel(Integer id){
        Result result = new Result();
        int code = userService.userDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public User userInfo(Integer id){
       return userService.userInfo(id);
    }

    @RequestMapping("/userUpd")
    @ResponseBody
    public Result userUpd(User user){
        Result result = new Result();
        User byUsername = userService.getByUsername(user.getUsername(), user.getRole());
        if (byUsername == null){
            int code = userService.userUpd(user);
            result.setCode(code);
            if (code == 1){
                result.setMsg("修改成功");
            }else{
                result.setMsg("修改失败");
            }
        }else{
            result.setCode(0);
            result.setMsg("同一角色用户名重复");
        }
        return result;
    }

}
