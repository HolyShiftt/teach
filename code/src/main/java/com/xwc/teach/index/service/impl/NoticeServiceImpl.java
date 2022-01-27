package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.NoticeDao;
import com.xwc.teach.index.entity.Notice;
import com.xwc.teach.index.entity.User;
import com.xwc.teach.index.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> selectAll() {
        return noticeDao.selectAll();
    }

    @Override
    public int noticeAdd(Notice notice) {
        return noticeDao.noticeAdd(notice);
    }

    @Override
    public int noticeDel(Integer id) {
        return noticeDao.noticeDel(id);
    }

    @Override
    public Notice noticeInfo(Integer id) {
        return noticeDao.noticeInfo(id);
    }

    @Override
    public int noticeUpd(Notice notice) {
        return noticeDao.noticeUpd(notice);
    }
}
