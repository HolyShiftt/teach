package com.xwc.teach.exam.service;

import com.xwc.teach.exam.entity.Question;

import java.util.List;

public interface QuestionService {

    List<Question> selectAll();

    int questionAdd(Question question);

    int questionDel(Integer id);

    Question questionInfo(Integer id);

    int questionUpd(Question question);
}
