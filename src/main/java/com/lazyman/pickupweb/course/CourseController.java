package com.lazyman.pickupweb.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author chenxiaoqi on 2018/2/18.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseDao courseDao;

    private TeacherDao teacherDao;

    @RequestMapping("/add")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    public Result add(Course course, @RequestParam Integer teacherId){
        Teacher teacher = teacherDao.load(teacherId);
        course.setTeacher(teacher);
        courseDao.save(course);
        return Result.SUCCESS;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Course> list(){
        return  courseDao.findAll();
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}
