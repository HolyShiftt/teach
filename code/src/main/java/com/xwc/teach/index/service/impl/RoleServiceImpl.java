package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.RoleMapper;
import com.xwc.teach.index.entity.Role;
import com.xwc.teach.index.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }
}
