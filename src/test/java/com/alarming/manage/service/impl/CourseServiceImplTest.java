package com.alarming.manage.service.impl;

import com.alarming.manage.objectdata.Course;
import com.alarming.manage.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname CourseServiceImplTest
 * @Description TODO
 * @Date 2021/4/17 14:21
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void saveCourse() {
        Course course = new Course();
        course.setCode("A005");
        course.setName("大学生创新与创业");
        courseService.saveCourse(course);
    }
}