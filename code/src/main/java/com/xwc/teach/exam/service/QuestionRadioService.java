package com.xwc.teach.exam.service;

import com.xwc.teach.exam.entity.QuestionRadio;

import java.util.List;

public interface QuestionRadioService {

    List<QuestionRadio> selectRadioAll(String subject, String search);

    int questionRadioAdd(QuestionRadio questionRadio);

    int questionRadioDel(Integer id);

    QuestionRadio questionRadioInfo(Integer id);

    int questionRadioUpd(QuestionRadio questionRadio);
}
