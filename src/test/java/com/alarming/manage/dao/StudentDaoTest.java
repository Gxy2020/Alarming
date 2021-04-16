package com.alarming.manage.dao;

import com.alarming.manage.enums.ResultEnums;
import com.alarming.manage.exception.AlarmingException;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.objectdata.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author GUO
 * @Classname StudentDaoTest
 * @Description TODO
 * @Date 2021/3/31 23:32
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
 public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private SClassDao sClassDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private SClassDao sclassDao;

    @Test
    public void findByUserAndPassword(){
        Student student = studentDao.findByUserAndPassword("20210030101","123456");
        if (student!=null){
            log.info("【学生登录】登录成功：student={}",student);
        }else {
            log.info(String.valueOf(student==null));
            student=null;
            log.info("【学生登录】登录失败");
        }
//        log.info(student.toString());
    }
//    @Transactional
    @Test
    public void findByStuId(){
        Student student = studentDao.getOne(1);
        System.out.println(student.toString());
    }
    @Test
    public void testSave(){
        Student student=new Student();
        student.setUser("20210030101");
        student.setUsername("瞎子");
        student.setPassword("123456");
        student.setSex("");
        student.setYear("2021");
        student.setPhone("123456");
        student.setEmail("123456@qq.com");

//        Department department = departmentDao.getOne(3);
//        student.setDepartments(department);

//        Major major = majorDao.getOne(1);
//        student.setMajors(major);
        student.setCreateTime("");
//        SClass sClass = sClassDao.getOne(1);
//        student.setsClass(sClass);
        Student students = studentDao.save(student);
        log.info(String.valueOf(students));
    }
    @Test
    public void findAll(){
        List<Student> studentList = studentDao.findAll();
        System.out.println(studentList);
    }
    @Test
    public void findCountByClassId(){
        Integer count = studentDao.findCountByClassId(4);
        log.info(String.valueOf(count));
    }
}