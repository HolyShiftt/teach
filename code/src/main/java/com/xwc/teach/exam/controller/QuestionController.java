package com.xwc.teach.exam.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.Question;
import com.xwc.teach.exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/exam")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping("/questionList")
    @ResponseBody
    public Table questionList(){
        List<Question> list = questionService.selectAll();
        return Table.success(list);
    }

    @RequestMapping("/questionAdd")
    @ResponseBody
    public Result questionAdd(Question question){
        Result result = new Result();
        int code = questionService.questionAdd(question);
        result.setCode(code);
        if (code == 1){
            result.setMsg("添加成功");
        }else{
            result.setMsg("添加失败");
        }
        return result;
    }

    @RequestMapping("/questionDel")
    @ResponseBody
    public Result questionDel(Integer id){
        Result result = new Result();
        int code = questionService.questionDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/questionInfo")
    @ResponseBody
    public Question questionInfo(Integer id){
        return questionService.questionInfo(id);
    }

    @RequestMapping("/questionUpd")
    @ResponseBody
    public Result questionUpd(Question question){
        Result result = new Result();
        int code = questionService.questionUpd(question);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }
}
