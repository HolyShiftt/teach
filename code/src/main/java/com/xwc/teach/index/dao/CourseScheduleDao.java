package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.CourseSchedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseScheduleDao {
    List<CourseSchedule> getList(Integer grade,Integer sClass);
}
