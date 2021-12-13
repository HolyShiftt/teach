package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.CourseScheduleDao;
import com.xwc.teach.index.entity.CourseSchedule;
import com.xwc.teach.index.service.CourseScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Autowired
    private CourseScheduleDao courseScheduleDao;


    @Override
    public List<CourseSchedule> getList(Integer grade, Integer sClass) {
        return courseScheduleDao.getList(grade, sClass);
    }
}
