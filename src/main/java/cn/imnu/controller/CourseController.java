package cn.imnu.controller;

import cn.imnu.bean.Course;
import cn.imnu.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class CourseController {
    @Autowired
    private CourseDAO courseDAO;
    /**
     * 添加课程
     */
    @PostMapping(value = "/add")
    public String add(Course course){
        CourseDAO.add(course);
        return "redirect:/getAll";
    }
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }
}
