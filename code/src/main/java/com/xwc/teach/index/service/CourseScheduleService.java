package com.xwc.teach.index.service;

import com.xwc.teach.index.entity.CourseSchedule;

import java.util.List;

public interface CourseScheduleService {
    List<CourseSchedule> getList(Integer grade, Integer sclass);

    int isExist(Integer grade,Integer sclass, Integer num);

    int courseAdd(CourseSchedule course);

    int courseDel(Integer id);

    CourseSchedule courseInfo(Integer id);

    int courseUpd(CourseSchedule course);

}
