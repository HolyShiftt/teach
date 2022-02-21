package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.CourseScheduleDao;
import com.xwc.teach.index.entity.CourseSchedule;
import com.xwc.teach.index.service.CourseScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Autowired
    private CourseScheduleDao courseScheduleDao;


    @Override
    public List<CourseSchedule> getList(Integer grade, Integer sclass) {
        return courseScheduleDao.getList(grade, sclass);
    }

    @Override
    public int isExist(Integer grade, Integer sclass, Integer num) {
        return courseScheduleDao.isExist(grade,sclass,num);
    }

    @Override
    public int courseAdd(CourseSchedule course) {
        return courseScheduleDao.courseAdd(course);
    }

    @Override
    public int courseDel(Integer id) {
        return courseScheduleDao.courseDel(id);
    }

    @Override
    public CourseSchedule courseInfo(Integer id) {
        return courseScheduleDao.courseInfo(id);
    }

    @Override
    public int courseUpd(CourseSchedule course) {
        return courseScheduleDao.courseUpd(course);
    }
}
