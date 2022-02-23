package com.xwc.teach.index.service;

import java.util.List;

public interface SchoolClassService {

    List<Integer> gradeList();

    List<Integer> classList(Integer grade);
}
