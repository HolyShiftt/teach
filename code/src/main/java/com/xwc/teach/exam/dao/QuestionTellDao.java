package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.QuestionRadio;
import com.xwc.teach.exam.entity.QuestionTell;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionTellDao {
    List<QuestionTell> selectTellAll(String subject, String search);

    List<QuestionTell> selectTellIds(String s, String subject);

    int questionTellAdd(QuestionTell questionTell);

    int questionTellDel(Integer id);

    QuestionTell questionTellInfo(Integer id);

    int questionTellUpd(QuestionTell questionTell);
}
