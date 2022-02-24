package com.xwc.teach.exam.service.impl;

import com.xwc.teach.exam.dao.QuestionTextDao;
import com.xwc.teach.exam.entity.QuestionText;
import com.xwc.teach.exam.service.QuestionTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTextServiceImpl implements QuestionTextService {
    @Autowired
    private QuestionTextDao questionTextDao;

    @Override
    public List<QuestionText> selectTextAll(String subject, String search) {
        return questionTextDao.selectTextAll(subject,search);
    }

    @Override
    public List<QuestionText> selectTextIds(List ids, String subject) {
        String s = ids.toString().replace("[[","(").replace("]]",")");
        return questionTextDao.selectTextIds(s,subject);
    }

    @Override
    public int questionTextAdd(QuestionText questionText) {
        return questionTextDao.questionTextAdd(questionText);
    }

    @Override
    public int questionTextDel(Integer id) {
        return questionTextDao.questionTextDel(id);
    }

    @Override
    public QuestionText questionTextInfo(Integer id) {
        return questionTextDao.questionTextInfo(id);
    }

    @Override
    public int questionTextUpd(QuestionText questionText) {
        return questionTextDao.questionTextUpd(questionText);
    }
}
