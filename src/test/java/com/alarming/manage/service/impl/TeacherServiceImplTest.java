package com.alarming.manage.service.impl;


import com.alarming.manage.objectdata.Teacher;
import com.alarming.manage.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname TeacherServiceImplTest
 * @Description TODO
 * @Date 2021/4/15 12:16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {
    @Autowired
    TeacherService teacherService;
    @Test
    public void saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setUser("fw123");
        teacher.setPassword("123456");
        teacherService.saveTeacher(teacher,3,7);
    }
    @Test
    public void delTeacher() {
        teacherService.delTeacher(5);
    }
}