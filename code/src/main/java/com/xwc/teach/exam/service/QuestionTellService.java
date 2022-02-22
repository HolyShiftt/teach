package com.xwc.teach.exam.service;

import com.xwc.teach.exam.entity.QuestionTell;

import java.util.List;

public interface QuestionTellService {

    List<QuestionTell> selectTellAll(String subject, String search);

    int questionTellAdd(QuestionTell questionTell);

    int questionTellDel(Integer id);

    QuestionTell questionTellInfo(Integer id);

    int questionTellUpd(QuestionTell questionTell);
}
