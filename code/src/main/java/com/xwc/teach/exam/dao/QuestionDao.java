package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionDao {
    List<Question> selectAll();

    int questionAdd(Question question);

    int questionDel(Integer id);

    Question questionInfo(Integer id);

    int questionUpd(Question question);
}
