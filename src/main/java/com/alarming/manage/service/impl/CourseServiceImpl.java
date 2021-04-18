package com.alarming.manage.service.impl;

import com.alarming.manage.dao.CourseDao;
import com.alarming.manage.objectdata.Course;
import com.alarming.manage.service.CourseService;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname CourseServiceImpl
 * @Description TODO
 * @Date 2021/4/17 3:18
 */
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public Page<Course> findCoursePage(Integer pageNum, Integer size) {
        Pageable pageable = PageRequest.of(pageNum, size);
        Page<Course> coursePage = courseDao.findAll(pageable);
        return coursePage;
    }

    @Override
    public boolean saveCourse(Course course) {
        Course course1 = courseDao.findByNameOrCode(course.getCode(), course.getCode());
        if (course1 != null) {
            return false;
        } else {
            course.setCreateTime(DateUtil.ToString());
            courseDao.save(course);
            return true;
        }
    }

    @Override
    public boolean delCourse(Integer id) {
        Course one = courseDao.getOne(id);
        if (one==null){

        return false;
        }else {
            courseDao.deleteById(id);
            return true;
        }
    }

    @Override
    public List<Course> findAll() {
        List<Course> courseList = courseDao.findAll();
        return courseList;
    }

    @Override
    public Integer findCourseCount() {
        Integer CourseCount = courseDao.countAllBy();
        return CourseCount;
    }
}
