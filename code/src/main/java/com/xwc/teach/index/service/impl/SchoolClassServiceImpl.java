package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.SchoolClassDao;
import com.xwc.teach.index.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolClassServiceImpl implements SchoolClassService {

    @Autowired
    private SchoolClassDao schoolClassDao;

    @Override
    public List<Integer> gradeList() {
        return schoolClassDao.gradeList();
    }

    @Override
    public List<Integer> classList(Integer grade) {
        return schoolClassDao.classList(grade);
    }
}
