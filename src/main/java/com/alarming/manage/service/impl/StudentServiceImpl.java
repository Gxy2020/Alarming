package com.alarming.manage.service.impl;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.dao.MajorDao;
import com.alarming.manage.dao.SClassDao;
import com.alarming.manage.dao.StudentDao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.StudentService;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private SClassDao sClassDao;

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
    public boolean saveStudent(Student student,Integer departmentId,Integer classId,Integer majorId) {
        Student s = studentDao.findByUser(student.getUser());
        if (s!=null){
        return false;
        }else {
            Department department = departmentDao.getOne(departmentId);
            Major major = majorDao.getOne(majorId);
            SClass one = sClassDao.getOne(classId);
            student.setsClass(one);
            student.setDepartments(department);
            student.setMajors(major);
            student.setCreateTime(DateUtil.ToString());
            studentDao.save(student);
            return true;
        }
    }

    @Override
    public boolean delStudent(int id) {
        Student student = studentDao.getOne(id);
        if (student==null){
        return false;
        }else {
            studentDao.deleteById(id);
            return true;
        }
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

    @Override
    public List<Student> findBySClassId(Integer classId) {
        SClass sClass = sClassDao.getOne(classId);
//        List<Student> studentList = studentDao.findBySclass(sClass);
        return null;
    }
}
