package com.xwc.teach.exam.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xwc.teach.commons.Pages;
import com.xwc.teach.commons.Result;
import com.xwc.teach.commons.Table;
import com.xwc.teach.exam.entity.*;
import com.xwc.teach.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping("/examList")
    @ResponseBody
    public Table examList(Integer teacherId, String search, Pages pages){
        Page<?> page = PageHelper.startPage(pages.getPage(), pages.getLimit());
        List<Exam> list = examService.selectAll(teacherId,search);
        return Table.success(Long.valueOf(page.getTotal()),list);
    }
    @RequestMapping("/examListStu")
    @ResponseBody
    public Table examListStu(Integer grade, Integer sclass,Integer stuId){
        List<Exam> list = examService.examListStu(grade,sclass,stuId);
        return Table.success(list);
    }

    @RequestMapping("/examAdd")
    @ResponseBody
    public Result examAdd(Exam exam){
        Result result = new Result();
        int code = examService.examAdd(exam);
        result.setCode(code);
        if (code == 1){
            result.setMsg("考卷生成成功");
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

    @RequestMapping("/showExamQuestion")
    @ResponseBody
    public ExamQuestion showExamQuestion(HttpSession session){
        ExamQuestion examQuestion = examService.showExamQuestion((Integer) session.getAttribute("examId"));
        examQuestion.setQuestionSum(examQuestion.getQuestionRadioList().size()+examQuestion.getQuestionTellList().size()+examQuestion.getQuestionTextList().size());
        return examQuestion;
    }

    @RequestMapping("/scoreList")
    @ResponseBody
    public Table scoreList(Integer id){
        List<Score> list = examService.scoreList(id);
        return Table.success(Long.valueOf(0),list);
    }

    @RequestMapping("/myScoreList")
    @ResponseBody
    public Table myScoreList(Integer stuId,String subject){
        List<Score> list = examService.myScoreList(stuId,subject);
        return Table.success(Long.valueOf(0),list);
    }

    @RequestMapping("/getScore")
    @ResponseBody
    public int getScore(ExamSub examSub,HttpSession session){
        int score = 0;
        String[] split = examSub.getAnswer().split(";");
        int questionNum = 0;
        ExamQuestion examQuestion = examService.showExamQuestion((Integer) session.getAttribute("examId"));
        examQuestion.setQuestionSum(examQuestion.getQuestionRadioList().size()+examQuestion.getQuestionTellList().size()+examQuestion.getQuestionTextList().size());
        for (QuestionRadio questionRadio : examQuestion.getQuestionRadioList()) {
            if (questionRadio.getAnswer().equals(split[questionNum])){
                score += examQuestion.getRadioScore();
            }
            questionNum++;
        }
        for (QuestionTell questionTell : examQuestion.getQuestionTellList()) {
            if (questionTell.getAnswer().equals(split[questionNum])){
                score += examQuestion.getTellScore();
            }
            questionNum++;
        }
        for (QuestionText questionText : examQuestion.getQuestionTextList()) {
            if (!split[questionNum].equals(" ")){
                if (questionText.getAnswer3()!=null){
                    String[] split1 = split[questionNum].split(",");
                    if (questionText.getAnswer3().equals(split1[2])){
                        score+=examQuestion.getTellScore();
                    }
                    if (questionText.getAnswer2().equals(split1[1])){
                        score+=examQuestion.getTellScore();
                    }
                    if (questionText.getAnswer1().equals(split1[0])){
                        score+=examQuestion.getTellScore();
                    }
                }else if (questionText.getAnswer2()!=null){
                    String[] split1 = split[questionNum].split(",");
                    if (questionText.getAnswer2().equals(split1[1])){
                        score+=examQuestion.getTellScore();
                    }
                    if (questionText.getAnswer1().equals(split1[0])){
                        score+=examQuestion.getTellScore();
                    }
                }else{
                    if (questionText.getAnswer1().equals(split[questionNum])){
                        score+=examQuestion.getTellScore();
                    }
                }
                questionNum++;
            }

        }
        examService.setScore((Integer)session.getAttribute("examId"),examSub.getStuId(),score);
        return score;
    }

    @RequestMapping("/checkExam")
    @ResponseBody
    public Result checkExam(Integer stuId,Integer examId){
        Result result = new Result();
        int code = examService.checkExam(stuId,examId);
        result.setCode(code);
        if (code == 1){
            result.setMsg("您已完成该考试，无需重复进入");
        }
        return result;
    }
}
