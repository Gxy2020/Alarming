package com.alarming.manage.service;

import com.alarming.manage.objectdata.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author GUO
 * @Classname StudentService
 * @Description 学生
 * @Date 2021/4/7 21:17
 */

public interface StudentService {
    Student findByUserAndPassword(String user,String password);

    boolean saveStudent(Student student);

    boolean delStudent(int id);

    Page<Student> findStudentPage(Integer pageNum,Integer size,String str);

    List<String>findByDepartment(String departmentName);

    List<Student>findByClassName(String className);
}
