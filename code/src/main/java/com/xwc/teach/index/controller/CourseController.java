package com.xwc.teach.index.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.commons.Pages;
import com.xwc.teach.index.entity.CourseSchedule;
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
    public Table courseScheduleList(Pages pages){
        Page<?> page = PageHelper.startPage(pages.getPage(), pages.getLimit());
        List<CourseSchedule> list = courseScheduleService.getList(1, 1);
        return Table.success(Long.valueOf(page.getTotal()),list);
    }

    @RequestMapping("/allCourseScheduleList")
    @ResponseBody
    public Table allCourseScheduleList(Pages pages,Integer grade, Integer sclass){
        Page<?> page = PageHelper.startPage(pages.getPage(), pages.getLimit());
        List<CourseSchedule> list = courseScheduleService.getList(grade, sclass);
        return Table.success(Long.valueOf(page.getTotal()),list);

    }

    @RequestMapping("/courseAdd")
    @ResponseBody
    public Result courseAdd(CourseSchedule course){
        Result result = new Result();
        if (courseScheduleService.isExist(course.getGrade(),course.getSclass(),course.getNum()) == 1){
            result.setMsg("已存在该班级该节次的课程");
        }else{
            int code = courseScheduleService.courseAdd(course);
            result.setCode(code);
            if (code == 1){
                result.setMsg("添加成功");
            }else{
                result.setMsg("添加失败");
            }
        }
        return result;
    }

    @RequestMapping("/courseDel")
    @ResponseBody
    public Result courseDel(Integer id){
        Result result = new Result();
        int code = courseScheduleService.courseDel(id);
        result.setCode(code);
        if (code == 1){
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/courseInfo")
    @ResponseBody
    public CourseSchedule courseInfo(Integer id){
        return courseScheduleService.courseInfo(id);
    }

    @RequestMapping("/courseUpd")
    @ResponseBody
    public Result courseUpd(CourseSchedule course){
        Result result = new Result();
        int code = courseScheduleService.courseUpd(course);
        result.setCode(code);
        if (code == 1){
            result.setMsg("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }
}
