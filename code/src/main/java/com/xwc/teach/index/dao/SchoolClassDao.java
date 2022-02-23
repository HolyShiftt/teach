package com.xwc.teach.index.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolClassDao {
    List<Integer> gradeList();

    List<Integer> classList(Integer grade);
}
