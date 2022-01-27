package com.xwc.teach.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    @DateTimeFormat(pattern = "HH:mm")
    private Date startTime;

    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    @DateTimeFormat(pattern = "HH:mm")
    private Date endTime;

}
