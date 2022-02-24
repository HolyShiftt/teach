package com.xwc.teach.exam.entity;

import lombok.Data;

@Data
public class Exam {

    private Integer id;

    private String name;

    private String startTime;

    private String endTime;

    private String subject;

    private Integer grade;

    private Integer sclass;

    private Integer teacherId;

    private String radioList;

    private Integer radioScore;

    private String tellList;

    private Integer tellScore;

    private String textList;

    private Integer textScore;

    private Integer sum;
}
