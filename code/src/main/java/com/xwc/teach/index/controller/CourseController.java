package com.xwc.teach.index.controller;

import com.xwc.teach.commons.Table;
import com.xwc.teach.index.entity.CourseSchedule;
import com.xwc.teach.index.entity.User;
import com.xwc.teach.index.service.CourseScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseScheduleService courseScheduleService;

    @RequestMapping("/courseScheduleList")
    @ResponseBody
    public Table courseScheduleList(){
        List<CourseSchedule> list = courseScheduleService.getList(1, 1);
        return Table.success(list);
    }

    @RequestMapping("/allCourseScheduleList")
    @ResponseBody
    public Table allCourseScheduleList(){
        List<CourseSchedule> list = courseScheduleService.getList(1, 1);
        return Table.success(list);
    }
}
