package com.xwc.teach.exam.service.impl;

import com.xwc.teach.exam.dao.ExamDao;
import com.xwc.teach.exam.dao.QuestionRadioDao;
import com.xwc.teach.exam.dao.QuestionTellDao;
import com.xwc.teach.exam.dao.QuestionTextDao;
import com.xwc.teach.exam.entity.*;
import com.xwc.teach.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;

    @Autowired
    private QuestionRadioDao questionRadioDao;
    @Autowired
    private QuestionTellDao questionTellDao;
    @Autowired
    private QuestionTextDao questionTextDao;

    @Override
    public List<Exam> selectAll(Integer teacherId,String search) {
        return examDao.selectAll(teacherId,search);
    }

    @Override
    public List<Exam> examListStu(Integer grade, Integer sclass,Integer stuId) {
        return examDao.examListStu(grade,sclass,stuId);
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

    @Override
    public ExamQuestion showExamQuestion(Integer id) {
        ExamQuestion examQuestion = new ExamQuestion();
        List<QuestionRadio> questionRadioList = new ArrayList<>();
        List<QuestionTell> questionTellList = new ArrayList<>();
        List<QuestionText> questionTextList = new ArrayList<>();
        Exam exam = examDao.examInfo(id);
        if (exam.getRadioList() != null){
            String radioList = exam.getRadioList();
            String[] radioSplit = radioList.split(",");
            for (String s : radioSplit) {
                questionRadioList.add(questionRadioDao.questionRadioInfo(Integer.parseInt(s)));
            }
            examQuestion.setQuestionRadioList(questionRadioList);
            examQuestion.setRadioScore(exam.getRadioScore());
        }
        if (exam.getTellList() != null){
            String tellList = exam.getTellList();
            String[] tellSplit = tellList.split(",");
            for (String s : tellSplit) {
                questionTellList.add(questionTellDao.questionTellInfo(Integer.parseInt(s)));
            }
            examQuestion.setQuestionTellList(questionTellList);
            examQuestion.setTellScore(exam.getTellScore());
        }
        if (exam.getTextList() != null){
            String textList = exam.getTextList();
            String[] textSplit = textList.split(",");
            for (String s : textSplit) {
                questionTextList.add(questionTextDao.questionTextInfo(Integer.parseInt(s)));
            }
            examQuestion.setQuestionTextList(questionTextList);
            examQuestion.setTextScore(exam.getTextScore());
        }
        examQuestion.setExamName(exam.getName());
        return examQuestion;
    }

    @Override
    public List<Score> scoreList(Integer id) {
        return examDao.scoreList(id);
    }

    @Override
    public List<Score> myScoreList(Integer stuId,String subject) {
        return examDao.myScoreList(stuId,subject);
    }

    @Override
    public void setScore(Integer examId, Integer stuId, Integer score) {
        examDao.setScore(examId,stuId,score);
    }

    @Override
    public int checkExam(Integer stuId,Integer examId) {
        return examDao.checkExam(examId,stuId);
    }


}
