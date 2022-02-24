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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
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
    @RequestMapping("/questionIds")
    @ResponseBody
    public Table questionIds(String[] ids,String subject,String type){
        ArrayList<String> idList = new ArrayList<>();
        Collections.addAll(idList, ids);
        switch (type) {
            case "radio": {
                List<QuestionRadio> list = questionRadioService.selectRadioIds(idList,subject);
                return Table.success(list);
            }
            case "tell": {
                List<QuestionTell> list = questionTellService.selectTellIds(idList, subject);
                return Table.success(list);
            }
            case "text": {
                List<QuestionText> list = questionTextService.selectTextIds(idList, subject);
                return Table.success(list);
            }
            default:
                return Table.success(0);
        }
    }

}
