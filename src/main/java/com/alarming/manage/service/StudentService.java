package com.alarming.manage.service;

import com.alarming.manage.objectdata.Student;
import com.alarming.manage.utils.PageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname StudentService
 * @Description 学生
 * @Date 2021/4/7 21:17
 */

public interface StudentService {
    Student findByUserAndPassword(String user,String password);
    Student findByUser(String user);
    boolean saveStudent(Student student,Integer departmentId,Integer classId,Integer majorId);

    boolean delStudent(int id);

    Page<Student> findStudentPage(Integer pageNum,Integer size,String str);

    List<String>findByDepartment(String departmentName);
    List<Student>findByClassName(String className);
    List<Student>findByClassId(Integer classId);
    List<Student>findByDepartmentIdOrClassId(Integer departmentId,Integer classId);
    Integer findStudentCount();
    Map findDepartmentStudentPage(Integer pageNum, Integer pageSize, Integer departmentId);
    Map findClassStudentPage(Integer pageNum, Integer pageSize,Integer classId);

}
