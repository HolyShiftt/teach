package com.xwc.teach.exam.entity;

import lombok.Data;

import java.util.List;

@Data
public class ExamQuestion {

    private List<QuestionRadio> questionRadioList;

    private List<QuestionTell> questionTellList;

    private List<QuestionText> questionTextList;

    private Integer radioScore;

    private Integer tellScore;

    private Integer textScore;
}
