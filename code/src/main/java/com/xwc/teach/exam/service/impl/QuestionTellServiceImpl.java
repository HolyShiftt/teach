package com.xwc.teach.exam.service.impl;

import com.xwc.teach.exam.dao.QuestionTellDao;
import com.xwc.teach.exam.entity.QuestionTell;
import com.xwc.teach.exam.service.QuestionTellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTellServiceImpl implements QuestionTellService {
    @Autowired
    private QuestionTellDao questionTellDao;

    @Override
    public List<QuestionTell> selectTellAll(String subject, String search) {
        return questionTellDao.selectTellAll(subject,search);
    }

    @Override
    public int questionTellAdd(QuestionTell questionTell) {
        return questionTellDao.questionTellAdd(questionTell);
    }

    @Override
    public int questionTellDel(Integer id) {
        return questionTellDao.questionTellDel(id);
    }

    @Override
    public QuestionTell questionTellInfo(Integer id) {
        return questionTellDao.questionTellInfo(id);
    }

    @Override
    public int questionTellUpd(QuestionTell questionTell) {
        return questionTellDao.questionTellUpd(questionTell);
    }
}
