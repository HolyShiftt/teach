package com.xwc.teach.index.service;

import com.xwc.teach.index.entity.Student;
import com.xwc.teach.index.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    User getByUsername(String username,Integer role);

    int updatePwd(Integer id,String password);

    List<User> selectAll(Integer role,String name);

    int userAdd(User user);

    int userDel(Integer id);

    User userInfo(Integer id);

    int userUpd(User user);

    int updPersonal(User user);

    Student getStuClass(Integer id);

}
