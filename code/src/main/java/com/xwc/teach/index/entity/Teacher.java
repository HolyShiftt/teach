package com.xwc.teach.index.entity;

import lombok.Data;

@Data
public class Teacher {
    private Integer userId;
    private Integer teacherId;
    private String edu;
    private String salary;
    private String subject;
    private Integer isCharge;
}
