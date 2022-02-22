package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.QuestionText;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionTextDao {
    List<QuestionText> selectTextAll(String subject, String search);

    int questionTextAdd(QuestionText questionText);

    int questionTextDel(Integer id);

    QuestionText questionTextInfo(Integer id);

    int questionTextUpd(QuestionText questionText);
}
