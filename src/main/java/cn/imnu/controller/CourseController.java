package cn.imnu.controller;

import cn.imnu.bean.Course;
import cn.imnu.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    /**
     * 查询全部课程
     * @return
     */
    @GetMapping(value = "/getAll")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses",courseDAO.getAll());
        return modelAndView;
    }
    /**
     * 通过id查询课程
     */
    @GetMapping(value = "/getById/{id}")
    public ModelAndView getByid(@PathVariable(value = "id")int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("course",courseDAO.getById(id));
        return modelAndView;
    }
    @PutMapping(value = "/update")
    public String update(Course course){
        courseDAO.update(course);
        return "redirect:/getAll";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value="id")int id){
        courseDAO.deleteByid(id);
        return "redirect:/getAll";
    }
}
