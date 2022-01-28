package com.xwc.teach.exam.service.impl;

import com.xwc.teach.exam.entity.Question;
import com.xwc.teach.exam.service.QuestionService;
import com.xwc.teach.exam.dao.QuestionDao;
import com.xwc.teach.exam.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> selectAll() {
        return questionDao.selectAll();
    }

    @Override
    public int questionAdd(Question question) {
        return questionDao.questionAdd(question);
    }

    @Override
    public int questionDel(Integer id) {
        return questionDao.questionDel(id);
    }

    @Override
    public Question questionInfo(Integer id) {
        return questionDao.questionInfo(id);
    }

    @Override
    public int questionUpd(Question question) {
        return questionDao.questionUpd(question);
    }
}
