package cn.imnu.dao;

import cn.imnu.bean.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class CourseDAO {
    private Map<Integer, Course> courses = new HashMap<Integer, Course>();

    /**
     * 新增课程
     */
    public void add(Course course) {
        courses.put(course.getId(),course);
    }

    /**
     * 查询全部课程
     */
    public Collection<Course> getAll() {
        return courses.values();
    }

    /**
     * 通过id查询课程
     */
    public Course getById(int id) {
        return courses.get(id);
    }

    public void update(Course course) {
        courses.put(course.getId(), course);
    }
    public void deleteByid(int id){
        courses.remove(id);
    }
}
