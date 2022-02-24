package com.xwc.teach.exam.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xwc.teach.commons.Pages;
import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.Exam;
import com.xwc.teach.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping("/examList")
    @ResponseBody
    public Table examList(String subject, String search, Pages pages){
        Page<?> page = PageHelper.startPage(pages.getPage(), pages.getLimit());
        List<Exam> list = examService.selectAll(subject,search);
        return Table.success(Long.valueOf(page.getTotal()),list);
    }

    @RequestMapping("/examAdd")
    @ResponseBody
    public Result examAdd(Exam exam){
        Result result = new Result();
        int code = examService.examAdd(exam);
        result.setCode(code);
        if (code == 1){
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/examDel")
    @ResponseBody
    public Result examDel(Integer id){
        Result result = new Result();
        int code = examService.examDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/examInfo")
    @ResponseBody
    public Exam examInfo(Integer id){
        return examService.examInfo(id);
    }

    @RequestMapping("/examUpd")
    @ResponseBody
    public Result examUpd(Exam exam){
        Result result = new Result();
        int code = examService.examUpd(exam);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }
}
