package com.xwc.teach.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CourseSchedule {
    private Integer id;
    private Integer grade;
    private Integer sClass;
    private Integer num;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    private String startTime;
    private String endTime;

}
