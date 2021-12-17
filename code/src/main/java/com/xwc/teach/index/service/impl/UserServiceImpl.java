package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.UserDao;
import com.xwc.teach.index.entity.User;
import com.xwc.teach.index.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User getStudentByUsername(String username) {
        return userDao.getStudentByUsername(username);
    }

    @Override
    public int updatePwd(Integer id, String password) {
        return  userDao.updatePwd(id,password);
    }

    @Override
    public List<User> selectAll(Integer role,String name) {
        return userDao.selectAll(role,name);
    }
}
