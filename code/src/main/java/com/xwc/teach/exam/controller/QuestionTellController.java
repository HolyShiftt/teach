package com.xwc.teach.exam.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.QuestionTell;
import com.xwc.teach.exam.service.QuestionTellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/questionTell")
public class QuestionTellController {
    @Autowired
    private QuestionTellService questionTellService;

    @RequestMapping("/questionTellList")
    @ResponseBody
    public Table questionTellList(String subject,String search){
        List<QuestionTell> list = questionTellService.selectTellAll(subject,search);
        return Table.success(list);
    }

    @RequestMapping("/questionTellAdd")
    @ResponseBody
    public Result questionTellAdd(QuestionTell questionTell){
        Result result = new Result();
        int code = questionTellService.questionTellAdd(questionTell);
        result.setCode(code);
        if (code == 1){
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/questionTellDel")
    @ResponseBody
    public Result questionTellDel(Integer id){
        Result result = new Result();
        int code = questionTellService.questionTellDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/questionTellInfo")
    @ResponseBody
    public QuestionTell questionTellInfo(Integer id){
        return questionTellService.questionTellInfo(id);
    }

    @RequestMapping("/questionTellUpd")
    @ResponseBody
    public Result questionTellUpd(QuestionTell questionTell){
        Result result = new Result();
        int code = questionTellService.questionTellUpd(questionTell);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }


}
