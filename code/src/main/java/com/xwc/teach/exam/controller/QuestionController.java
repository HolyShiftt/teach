package com.xwc.teach.exam.controller;

import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.QuestionRadio;
import com.xwc.teach.exam.entity.QuestionTell;
import com.xwc.teach.exam.entity.QuestionText;
import com.xwc.teach.exam.service.QuestionRadioService;
import com.xwc.teach.exam.service.QuestionTellService;
import com.xwc.teach.exam.service.QuestionTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionRadioService questionRadioService;

    @Autowired
    private QuestionTellService questionTellService;

    @Autowired
    private QuestionTextService questionTextService;

    @RequestMapping("/questionList")
    @ResponseBody
    public Table questionList(String type,String subject,String search){
        switch (type) {
            case "radio": {
                List<QuestionRadio> list = questionRadioService.selectRadioAll(subject, search);
                return Table.success(list);
            }
            case "tell": {
                List<QuestionTell> list = questionTellService.selectTellAll(subject, search);
                return Table.success(list);
            }
            case "text": {
                List<QuestionText> list = questionTextService.selectTextAll(subject, search);
                return Table.success(list);
            }
            default:
                return Table.success(0);
        }
    }

//    @RequestMapping("/questionAdd")
//    @ResponseBody
//    public Result questionAdd(Question question){
//        Result result = new Result();
//        int code = questionService.questionAdd(question);
//        result.setCode(code);
//        if (code == 1){
//            result.setMsg("添加成功");
//        }else{
//            result.setMsg("添加失败");
//        }
//        return result;
//    }
//
//    @RequestMapping("/questionDel")
//    @ResponseBody
//    public Result questionDel(Integer id){
//        Result result = new Result();
//        int code = questionService.questionDel(id);
//        result.setCode(code);
//        if (code == 1){
//            result.setMsg("删除成功");
//        }else{
//            result.setMsg("删除失败");
//        }
//        return result;
//    }
//
//    @RequestMapping("/questionInfo")
//    @ResponseBody
//    public Question questionInfo(Integer id){
//        return questionService.questionInfo(id);
//    }
//
//    @RequestMapping("/questionUpd")
//    @ResponseBody
//    public Result questionUpd(Question question){
//        Result result = new Result();
//        int code = questionService.questionUpd(question);
//        result.setCode(code);
//        if (code == 1){
//            result.setMsg("修改成功");
//        }else{
//            result.setMsg("修改失败");
//        }
//        return result;
//    }


}
