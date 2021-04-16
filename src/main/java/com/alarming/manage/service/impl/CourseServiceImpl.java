package com.alarming.manage.service.impl;

import com.alarming.manage.dao.CourseDao;
import com.alarming.manage.objectdata.Course;
import com.alarming.manage.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Pageable pageable= PageRequest.of(pageNum,size);
        Page<Course> coursePage = courseDao.findAll(pageable);
        return coursePage;
    }
}
