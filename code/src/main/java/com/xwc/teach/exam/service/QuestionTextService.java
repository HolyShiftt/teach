package com.xwc.teach.exam.service;

import com.xwc.teach.exam.entity.QuestionTell;
import com.xwc.teach.exam.entity.QuestionText;

import java.util.List;

public interface QuestionTextService {

    List<QuestionText> selectTextAll(String subject, String search);

    List<QuestionText> selectTextIds(List ids, String subject);

    int questionTextAdd(QuestionText questionText);

    int questionTextDel(Integer id);

    QuestionText questionTextInfo(Integer id);

    int questionTextUpd(QuestionText questionText);
}
