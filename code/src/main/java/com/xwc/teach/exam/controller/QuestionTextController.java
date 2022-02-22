package com.xwc.teach.exam.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.QuestionText;
import com.xwc.teach.exam.service.QuestionTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/questionText")
public class QuestionTextController {
    @Autowired
    private QuestionTextService questionTextService;

    @RequestMapping("/questionTextList")
    @ResponseBody
    public Table questionTextList(String subject,String search){
        List<QuestionText> list = questionTextService.selectTextAll(subject,search);
        return Table.success(list);
    }

    @RequestMapping("/questionTextAdd")
    @ResponseBody
    public Result questionTextAdd(QuestionText questionText){
        Result result = new Result();
        int code = questionTextService.questionTextAdd(questionText);
        result.setCode(code);
        if (code == 1){
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/questionTextDel")
    @ResponseBody
    public Result questionTextDel(Integer id){
        Result result = new Result();
        int code = questionTextService.questionTextDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/questionTextInfo")
    @ResponseBody
    public QuestionText questionTextInfo(Integer id){
        return questionTextService.questionTextInfo(id);
    }

    @RequestMapping("/questionTextUpd")
    @ResponseBody
    public Result questionTextUpd(QuestionText questionText){
        Result result = new Result();
        int code = questionTextService.questionTextUpd(questionText);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }


}
