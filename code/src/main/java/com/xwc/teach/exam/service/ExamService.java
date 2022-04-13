package com.xwc.teach.exam.service;

import com.xwc.teach.exam.entity.Exam;
import com.xwc.teach.exam.entity.ExamQuestion;
import com.xwc.teach.exam.entity.Score;

import java.util.List;

public interface ExamService {
    List<Exam> selectAll(Integer teacherId, String search);

    List<Exam> examListStu(Integer grade, Integer sclass,Integer stuId);

    int examAdd(Exam exam);

    int examDel(Integer id);

    Exam examInfo(Integer id);

    int examUpd(Exam exam);

    ExamQuestion showExamQuestion(Integer id);

    List<Score> scoreList(Integer id);

    List<Score> myScoreList(Integer stuId,String subject);

    void setScore(Integer examId,Integer stuId, Integer score);

    int checkExam(Integer stuId,Integer examId);
}
