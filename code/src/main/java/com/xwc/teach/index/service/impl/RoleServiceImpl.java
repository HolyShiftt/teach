package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.RoleDao;
import com.xwc.teach.index.entity.Role;
import com.xwc.teach.index.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }
}
