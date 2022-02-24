package com.xwc.teach.exam.service;

import com.xwc.teach.exam.entity.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> selectAll(Integer teacherId, String search);

    List<Exam> examListStu(Integer grade, Integer sclass);

    int examAdd(Exam exam);

    int examDel(Integer id);

    Exam examInfo(Integer id);

    int examUpd(Exam exam);
}
