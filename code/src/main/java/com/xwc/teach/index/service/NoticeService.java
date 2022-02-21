package com.xwc.teach.index.service;

import com.xwc.teach.index.entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> selectAll(Integer limit);

    List<Notice> selectAll2();

    int noticeAdd(Notice notice);

    int noticeDel(Integer id);

    Notice noticeInfo(Integer id);

    int noticeUpd(Notice notice);
}
