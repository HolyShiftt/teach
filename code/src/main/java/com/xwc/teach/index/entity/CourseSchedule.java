package com.xwc.teach.index.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseSchedule {
    private Integer id;
    private Integer grade;
    private Integer sClass;
    private Integer num;
    private String mondayCourse;
    private String tuesdayCourse;
    private String wednesdayCourse;
    private String thursdayCourse;
    private String fridayCourse;
    private String saturdayCourse;
    private String sundayCourse;

    private String startTime;
    private String endTime;

}
