package com.alarming.manage.service.impl;

import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname StudentServiceImplTest
 * @Description TODO
 * @Date 2021/4/15 14:53
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void findByUserAndPassword() {
    }

    @Test
    public void saveStudent() {
    }

    @Test
    public void delStudent() {
    }

    @Test
    public void findAll() {
//        Page<Student> studentPage = studentService.();
//        log.info(String.valueOf(studentPage));
    }

    @Test
    public void findByDepartment() {
    }

    @Test
    public void findByClassName() {
    }
}