package com.xwc.teach.exam.entity;

import lombok.Data;

@Data
public class QuestionRadio {
    private Integer id;
    private String subject;
    private String title;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer;
    private String answerInfo;
}
