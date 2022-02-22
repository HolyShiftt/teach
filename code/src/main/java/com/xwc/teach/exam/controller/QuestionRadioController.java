package com.xwc.teach.exam.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.QuestionRadio;
import com.xwc.teach.exam.service.QuestionRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/questionRadio")
public class QuestionRadioController {
    @Autowired
    private QuestionRadioService questionRadioService;

    @RequestMapping("/questionRadioList")
    @ResponseBody
    public Table questionRadioList(String subject,String search){
        List<QuestionRadio> list = questionRadioService.selectRadioAll(subject,search);
        return Table.success(list);
    }

    @RequestMapping("/questionRadioAdd")
    @ResponseBody
    public Result questionRadioAdd(QuestionRadio questionRadio){
        Result result = new Result();
        int code = questionRadioService.questionRadioAdd(questionRadio);
        result.setCode(code);
        if (code == 1){
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/questionRadioDel")
    @ResponseBody
    public Result questionRadioDel(Integer id){
        Result result = new Result();
        int code = questionRadioService.questionRadioDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/questionRadioInfo")
    @ResponseBody
    public QuestionRadio questionRadioInfo(Integer id){
        return questionRadioService.questionRadioInfo(id);
    }

    @RequestMapping("/questionRadioUpd")
    @ResponseBody
    public Result questionRadioUpd(QuestionRadio questionRadio){
        Result result = new Result();
        int code = questionRadioService.questionRadioUpd(questionRadio);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }


}
