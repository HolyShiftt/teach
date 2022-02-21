package com.xwc.teach.index.dao;

import com.xwc.teach.index.entity.Notice;
import com.xwc.teach.index.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao {

    List<Notice> selectAll(Integer limit);

    int noticeAdd(Notice notice);

    int noticeDel(Integer id);

    Notice noticeInfo(Integer id);

    int noticeUpd(Notice notice);
}
