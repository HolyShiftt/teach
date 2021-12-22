package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    User getUserById(Integer id);

    User getByUsername(String username,Integer role);

    int updatePwd(Integer id,String password);

    List<User> selectAll(Integer role,String name);

}
