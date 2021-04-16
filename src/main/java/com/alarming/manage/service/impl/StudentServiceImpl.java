package com.alarming.manage.service.impl;

import com.alarming.manage.dao.StudentDao;
import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname StudentServiceIml
 * @Description TODO
 * @Date 2021/4/7 21:34
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findByUserAndPassword(String user, String password) {
        Student student = studentDao.findByUserAndPassword(user, password);
        if (student!=null){
            log.info("【用户登录】登录成功，student={}",student);
            return student;
        }else {
            log.info("【用户登录】登录失败，user={},password={}",user,password);
            return null;
        }
    }

    @Override
    public boolean saveStudent(Student student) {
        return false;
    }

    @Override
    public boolean delStudent(int id) {
        return false;
    }

    @Override
    public Page<Student> findStudentPage(Integer pageNum,Integer size ,String str) {
        Pageable pageable=PageRequest.of(pageNum,size, Sort.by(Sort.Direction.ASC,str));
        Page<Student> studentPage=studentDao.findAll(pageable);
        return studentPage;
    }

    @Override
    public List<String> findByDepartment(String departmentName) {
        return null;
    }

    @Override
    public List<Student> findByClassName(String className) {
        return null;
    }
}
