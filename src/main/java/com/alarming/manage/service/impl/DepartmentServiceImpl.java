package com.alarming.manage.service.impl;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.dao.MajorDao;
import com.alarming.manage.dao.SClassDao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.service.DepartmentService;
import com.alarming.manage.utils.DateUtil;
import com.alarming.manage.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GUO
 * @Classname DepartmentServiceImpl
 * @Description TODO
 * @Date 2021/4/5 18:31
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private SClassDao sClassDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<DepartmentVO> findDepartments() {
        //1.查询所有院系的列表
        List<Department> departmentList = departmentDao.findAll();
        List list = new ArrayList();
        for (Department department : departmentList) {
            DepartmentVO departmentVO = new DepartmentVO();
            Integer majorNum = majorDao.findMajorNum(department.getDepartmentId());
            Integer classNum = sClassDao.findClassNum(department.getDepartmentId());
            departmentVO.setDepartmentId(department.getDepartmentId());
            departmentVO.setName(department.getName());
            departmentVO.setMajorNum(majorNum);
            departmentVO.setClassNum(classNum);
            departmentVO.setCreateTime(department.getCreateTime());
            list.add(departmentVO);
        }
        return list;
    }

    @Override
    public boolean saveDepart(Department department) {
        Department name = departmentDao.findByName(department.getName());
        if (name != null) {
            return false;
        } else {
            department.setCreateTime(DateUtil.ToString());
            departmentDao.save(department);
            return true;
        }
    }

    @Override
    public boolean delDepart(int id) {
        Department department = departmentDao.getOne(id);
        if (department == null) {
            return false;
        } else {
            departmentDao.deleteById(id);
            return true;
        }
    }

    @Override
    public boolean updateDepartment(Integer departmentId, String name) {
        Department byName = departmentDao.findByName(name);
        if (byName != null) {
            return false;
        } else {
            Department department = departmentDao.getOne(departmentId);
            department.setName(name);
            return true;
        }
    }
}
