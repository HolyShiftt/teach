package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.QuestionRadio;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionRadioDao {
    List<QuestionRadio> selectRadioAll(String subject, String search);

    int questionRadioAdd(QuestionRadio questionRadio);

    int questionRadioDel(Integer id);

    QuestionRadio questionRadioInfo(Integer id);

    int questionRadioUpd(QuestionRadio questionRadio);
}
