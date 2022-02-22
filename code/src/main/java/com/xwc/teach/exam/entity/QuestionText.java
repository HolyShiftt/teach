package com.xwc.teach.exam.entity;

import lombok.Data;

@Data
public class QuestionText {
    private Integer id;
    private String subject;
    private String title;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answerInfo;
}
