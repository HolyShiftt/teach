package com.xwc.teach.exam.service.impl;

import com.xwc.teach.exam.entity.QuestionRadio;
import com.xwc.teach.exam.service.QuestionRadioService;
import com.xwc.teach.exam.dao.QuestionRadioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionRadioServiceImpl implements QuestionRadioService {
    @Autowired
    private QuestionRadioDao questionRadioDao;

    @Override
    public List<QuestionRadio> selectRadioAll(String subject, String search) {
        return questionRadioDao.selectRadioAll(subject,search);
    }

    @Override
    public List<QuestionRadio> selectRadioIds(List ids, String subject) {
        String s = ids.toString().replace("[[","(").replace("]]",")");
        return questionRadioDao.selectRadioIds(s,subject);
    }

    @Override
    public int questionRadioAdd(QuestionRadio questionRadio) {
        return questionRadioDao.questionRadioAdd(questionRadio);
    }

    @Override
    public int questionRadioDel(Integer id) {
        return questionRadioDao.questionRadioDel(id);
    }

    @Override
    public QuestionRadio questionRadioInfo(Integer id) {
        return questionRadioDao.questionRadioInfo(id);
    }

    @Override
    public int questionRadioUpd(QuestionRadio questionRadio) {
        return questionRadioDao.questionRadioUpd(questionRadio);
    }
}
