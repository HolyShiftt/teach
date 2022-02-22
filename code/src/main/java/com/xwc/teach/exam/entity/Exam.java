package com.xwc.teach.exam.entity;

import lombok.Data;

@Data
public class Exam {

    private Integer id;

    private String name;

    private String start_time;

    private String end_time;

    private String subject;

    private Integer grade;

    private Integer exam_class;
}
