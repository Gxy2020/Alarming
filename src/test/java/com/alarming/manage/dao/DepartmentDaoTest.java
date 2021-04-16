package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Department;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;


/**
 * @author GUO
 * @Classname DepartmentDaoTest
 * @Description TODO
 * @Date 2021/4/5 17:29
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public  class DepartmentDaoTest {

    @Autowired
    private  DepartmentDao departmentDao;
    //查询所以
    @Test
    public void testFindAll(){
        List<Department> departmentList = departmentDao.findAll();
        System.out.println(departmentList);
    }
    //查询总数
    @Test
    public void testCount(){
        long l = departmentDao.count();
        log.info(String.valueOf(l));
    }
    //保存
    @Test
    public void testSave(){
        Department department = new Department();
        department.setName("经管院");
        department.setCreateTime(DateUtil.ToString());
        departmentDao.save(department);
    }
    //按名字查询
    @Test
    public void testFindByName(){
        Department department = departmentDao.findByName("经管院");
        log.info(String.valueOf(department));
    }


}