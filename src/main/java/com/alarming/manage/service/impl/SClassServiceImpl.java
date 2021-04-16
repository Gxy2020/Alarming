package com.alarming.manage.service.impl;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.dao.SClassDao;
import com.alarming.manage.dao.TeacherDao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.service.SClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author GUO
 * @Classname SClassServiceImpl
 * @Description TODO
 * @Date 2021/4/14 17:57
 */
@Slf4j
@Service
public class SClassServiceImpl implements SClassService {
    @Autowired
    private SClassDao sClassDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<SClass> findAll() {
        List<SClass> classList = sClassDao.findAll();
        return classList;
    }

    /**
     * 按照院系查找学生所在的班级
     * @param departmentId
     * @return
     */
    @Override
    public List<SClass> findByDepartment(Integer departmentId) {
        Department department = departmentDao.getOne(departmentId);
        List<SClass> classList = sClassDao.findByDepartment(department);
        return classList;
    }
    /**
     * 添加班主任,查询没有班主任的班级
     * @param departmentId
     * @return
     */
    @Override
    public List<SClass> findByDepartmentId(Integer departmentId) {
        //按院系查询班级id
        List<Integer> list1 = sClassDao.findByDepartmentId(departmentId);
        //查询已有班主任的班级id
        List<Integer> list2 = teacherDao.findAllClass();
        //过滤已有班主任的班级id
        List<Integer>list=list1.stream().filter(integer -> !list2.contains(integer)).collect(Collectors.toList());
        //按List的id查询,返回List<SClass>对象
        List<SClass> classList = sClassDao.findList(list);
        return classList;
    }
}
