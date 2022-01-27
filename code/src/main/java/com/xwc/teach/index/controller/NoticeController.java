package com.xwc.teach.index.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.index.entity.Notice;
import com.xwc.teach.index.entity.User;
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

    @RequestMapping("/noticeAdd")
    @ResponseBody
    public Result noticeAdd(Notice notice){
        Result result = new Result();
        int code = noticeService.noticeAdd(notice);
        result.setCode(code);
        if (code == 1){
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/noticeDel")
    @ResponseBody
    public Result noticeDel(Integer id){
        Result result = new Result();
        int code = noticeService.noticeDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/noticeInfo")
    @ResponseBody
    public Notice noticeInfo(Integer id){
        return noticeService.noticeInfo(id);
    }

    @RequestMapping("/noticeUpd")
    @ResponseBody
    public Result noticeUpd(Notice notice){
        Result result = new Result();
        int code = noticeService.noticeUpd(notice);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }
}
