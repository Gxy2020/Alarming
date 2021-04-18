package com.alarming.manage.service;

import com.alarming.manage.objectdata.Course;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author GUO
 * @Classname CourseService
 * @Description TODO
 * @Date 2021/4/17 3:16
 */
public interface CourseService {
    Page<Course>findCoursePage(Integer pageNum,Integer size);
    boolean saveCourse(Course course);
    boolean delCourse(Integer id);
    List<Course>findAll();
}
