package com.alarming.manage.service.impl;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.dao.SClassDao;
import com.alarming.manage.dao.TeacherDao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.objectdata.Teacher;
import com.alarming.manage.service.TeacherService;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname TeacherServiceImpl
 * @Description TODO
 * @Date 2021/4/8 18:10
 */
@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private SClassDao sClassDao;

    @Override
    public Teacher findByUserAndPassword(String user, String password) {
        Teacher teacher = teacherDao.findByUserAndPassword(user, password);
        if (teacher != null) {
            log.info("【用户登录】登录成功，teacher={}", teacher);
            return teacher;
        } else {
            log.info("【用户登录】登录失败，user={},password={}", user, password);
            return null;
        }
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teacherList = teacherDao.findAll();
        return teacherList;
    }
    @Override
    public boolean saveTeacher(Teacher teacher, Integer departmentId, Integer classId) {
        if (teacher != null) {
            teacher.setCreateTime(DateUtil.ToString());
            if(departmentId != null & classId != null) {
                Department department = departmentDao.getOne(departmentId);
                SClass sClass = sClassDao.getOne(classId);
                teacher.settDepartment(department);
                teacher.setsClass(sClass);
                teacherDao.save(teacher);
                return true;
            }if (departmentId != null& classId == null ){
                Department department = departmentDao.getOne(departmentId);
                teacher.settDepartment(department);
                teacherDao.save(teacher);
                return true;
            }
            else {
                teacherDao.save(teacher);
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean delTeacher(Integer id) {
        Teacher teacher = teacherDao.getOne(id);
        if (teacher == null) {
            log.info("删除失败");
            return false;
        } else {
            teacherDao.deleteById(id);
            log.info("删除成功");
            return true;
        }
    }

    @Override
    public Teacher findByUser(String user) {
        Teacher teacher = teacherDao.findByUser(user);
        return teacher;
    }

    @Override
    public void updateTeacher(String password, String username, String sex, String phone, String email, Integer id) {
        teacherDao.updateTeacher(password, username, sex, phone, email, id);
    }
}
