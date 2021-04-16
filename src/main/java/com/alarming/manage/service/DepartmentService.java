package com.alarming.manage.service;

import com.alarming.manage.objectdata.Department;
import com.alarming.manage.vo.DepartmentVO;

import java.util.List;

/**
 * @author GUO
 * @Classname DepartmentService
 * @Description TODO
 * @Date 2021/4/5 18:30
 */
public interface DepartmentService {
    List<Department> findAll();
    List<DepartmentVO>findDepartments();
    //添加
    boolean saveDepart(Department department);
    //删除
    boolean delDepart(int id);
    boolean updateDepartment(Integer departmentId,String name);
}
