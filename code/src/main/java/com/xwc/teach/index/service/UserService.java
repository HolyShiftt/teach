package com.xwc.teach.index.service;

import com.xwc.teach.index.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    User getByUsername(String username,Integer role);

    int updatePwd(Integer id,String password);

    List<User> selectAll(Integer role,String name);

}
