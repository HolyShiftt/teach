package com.xwc.teach.exam.entity;

import lombok.Data;

@Data
public class QuestionTell {
    private Integer id;
    private String subject;
    private String title;
    private String answer;
    private String answerInfo;
}
