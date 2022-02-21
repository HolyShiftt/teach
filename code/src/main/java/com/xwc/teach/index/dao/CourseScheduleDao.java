package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.CourseSchedule;
import com.xwc.teach.index.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseScheduleDao {
    List<CourseSchedule> getList(Integer grade,Integer sclass);

    int isExist(Integer grade, Integer sclass, Integer num);

    int courseAdd(CourseSchedule course);

    int courseDel(Integer id);

    CourseSchedule courseInfo(Integer id);

    int courseUpd(CourseSchedule course);
}
