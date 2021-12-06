package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserById(Integer id);

    User getUserByUsername(String username);

    int updatePwd(Integer id,String password);

}
