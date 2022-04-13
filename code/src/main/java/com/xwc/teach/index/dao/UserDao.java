package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.Student;
import com.xwc.teach.index.entity.Teacher;
import com.xwc.teach.index.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    User getUserById(Integer id);

    User getByUsername(String username,Integer role);

    int updatePwd(Integer id,String password);

    List<User> selectAll(Integer role,String name);

    int userAdd(String username, String realName, String password, Integer role);

    int userDel(Integer id);

    User userInfo(Integer id);

    int userUpd(String username, String realName, String password, Integer role, Integer id);

    int updPersonal(User user);

    Student getStuClass(Integer id);

    Teacher getTeacherSubject(Integer id);

    User getChild(Integer id);

}
