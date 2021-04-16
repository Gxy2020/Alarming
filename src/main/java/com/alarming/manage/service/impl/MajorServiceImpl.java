package com.alarming.manage.service.impl;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.dao.MajorDao;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import com.alarming.manage.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname MajorServiceImpl
 * @Description TODO
 * @Date 2021/4/14 17:22
 */
@Slf4j
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Major> findAll() {
        return majorDao.findAll();
    }

    @Override
    public List<Major> findByDepartmentId(Integer departmentId) {
        Department department = departmentDao.getOne(departmentId);
        List<Major> majorList = majorDao.findByDepartment(department);
        return majorList;
    }
}
