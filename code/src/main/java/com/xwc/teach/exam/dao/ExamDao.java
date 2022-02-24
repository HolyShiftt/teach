package com.xwc.teach.exam.dao;

import com.xwc.teach.exam.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    List<Exam> selectAll(Integer teacherId, String search);

    int examAdd(Exam exam);

    int examDel(Integer id);

    Exam examInfo(Integer id);

    int examUpd(Exam exam);
}
