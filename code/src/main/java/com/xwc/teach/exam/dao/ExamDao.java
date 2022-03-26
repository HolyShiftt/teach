package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.Exam;
import com.xwc.teach.exam.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    List<Exam> selectAll(Integer teacherId, String search);

    List<Exam> examListStu(Integer grade, Integer sclass);

    int examAdd(Exam exam);

    int examDel(Integer id);

    Exam examInfo(Integer id);

    int examUpd(Exam exam);

    List<Score> scoreList(Integer id);
}
