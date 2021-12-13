package com.xwc.teach.index.service;

import com.xwc.teach.index.entity.CourseSchedule;

import java.util.List;

public interface CourseScheduleService {
    List<CourseSchedule> getList(Integer grade, Integer sClass);
}
