package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUserByUsername(String username);
}
