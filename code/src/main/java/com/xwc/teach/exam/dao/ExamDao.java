package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.Exam;
import com.xwc.teach.exam.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    List<Exam> selectAll(Integer teacherId, String search);

    List<Exam> examListStu(Integer grade, Integer sclass, Integer stuId);

    int examAdd(Exam exam);

    int examDel(Integer id);

    Exam examInfo(Integer id);

    int examUpd(Exam exam);

    List<Score> scoreList(Integer id);

    List<Score> myScoreList(Integer stuId,String subject);

    void setScore(Integer examId, Integer stuId, Integer score);

    int checkExam(Integer stuId,Integer examId);
}
