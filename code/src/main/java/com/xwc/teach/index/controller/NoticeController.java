package com.xwc.teach.index.controller;

import com.xwc.teach.commons.Table;
import com.xwc.teach.index.entity.CourseSchedule;
import com.xwc.teach.index.entity.Notice;
import com.xwc.teach.index.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/noticeList")
    @ResponseBody
    public Table noticeList(){
        List<Notice> list = noticeService.selectAll();
        return Table.success(list);
    }

}
