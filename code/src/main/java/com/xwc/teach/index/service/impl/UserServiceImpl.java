package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.UserDao;
import com.xwc.teach.index.entity.User;
import com.xwc.teach.index.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getByUsername(String username,Integer role) {
        return userDao.getByUsername(username,role);
    }

    @Override
    public int updatePwd(Integer id, String password) {
        return  userDao.updatePwd(id,password);
    }

    @Override
    public List<User> selectAll(Integer role,String name) {
        return userDao.selectAll(role,name);
    }

    @Override
    public int userAdd(User user) {
        return userDao.userAdd(user.getUsername(), user.getRealName(), user.getPassword(), user.getRole());
    }

    @Override
    public int userDel(Integer id) {
        return userDao.userDel(id);
    }

    @Override
    public User userInfo(Integer id) {
        return userDao.userInfo(id);
    }

    @Override
    public int userUpd(User user) {
        return userDao.userUpd(user.getUsername(), user.getRealName(), user.getPassword(), user.getRole(), user.getId());
    }

    @Override
    public int updPersonal(User user) {
        return userDao.updPersonal(user);
    }
}
