package com.xwc.teach.index.controller;

import com.xwc.teach.index.entity.Role;
import com.xwc.teach.index.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/schoolClass")
public class SchoolClassController {

    @Autowired
    private SchoolClassService schoolClassService;

    @RequestMapping("/gradeList")
    @ResponseBody
    public List<Integer> gradeList(){
        return schoolClassService.gradeList();
    }

    @RequestMapping("/classList")
    @ResponseBody
    public List<Integer> classList(Integer grade){
        return schoolClassService.classList(grade);
    }
}
