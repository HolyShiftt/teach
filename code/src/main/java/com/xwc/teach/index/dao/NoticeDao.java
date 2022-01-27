package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao {

    List<Notice> selectAll();
}
