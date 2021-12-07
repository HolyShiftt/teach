package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> selectAll();
}
