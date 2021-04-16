package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author GUO
 * @Classname DepartmentDao
 * @Description TODO
 * @Date 2021/4/5 15:01
 */
public interface DepartmentDao extends JpaRepository<Department,Integer> {
   Department findByName(String name);
}
