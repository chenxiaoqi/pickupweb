package com.lazyman.pickupweb.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author chenxiaoqi on 2018/2/18.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherDao teacherDao;

    @RequestMapping("/add")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public Result add(Teacher teacher) {

        teacherDao.save(teacher);

        return Result.SUCCESS;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Teacher> list() {
        return teacherDao.findAll();
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}
