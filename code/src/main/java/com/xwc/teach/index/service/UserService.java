package com.xwc.teach.index.service;

import com.xwc.teach.index.entity.User;

public interface UserService {

    User getUserById(Integer id);

    User getUserByUsername(String username);

    int updatePwd(Integer id,String password);

}
