package com.xwc.teach.exam.service.impl;

import com.xwc.teach.exam.dao.ExamDao;
import com.xwc.teach.exam.entity.Exam;
import com.xwc.teach.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Override
    public List<Exam> selectAll(String subject,String search) {
        return examDao.selectAll(subject,search);
    }

    @Override
    public int examAdd(Exam exam) {
        return examDao.examAdd(exam);
    }

    @Override
    public int examDel(Integer id) {
        return examDao.examDel(id);
    }

    @Override
    public Exam examInfo(Integer id) {
        return examDao.examInfo(id);
    }

    @Override
    public int examUpd(Exam exam) {
        return examDao.examUpd(exam);
    }
}
