package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GUO
 * @Classname TeacherDaoTest
 * @Description TODO
 * @Date 2021/4/7 18:52
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
 public  class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testFindAll(){
        List<Teacher> teacherList = teacherDao.findAll();
        log.info(teacherList.toString());
    }
    @Test
    public void testFindByUserAndPassword(){
        Teacher teacher = teacherDao.findByUserAndPassword("202103001", "123456");
        log.info(teacher.toString());
    }
    @Test
    public void findAllClass(){
        List<Integer> teacherList = teacherDao.findAllClass();
        log.info(teacherList.toString());
    }
}