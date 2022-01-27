package com.xwc.teach.index.service.impl;

import com.xwc.teach.index.dao.NoticeDao;
import com.xwc.teach.index.entity.Notice;
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
}
