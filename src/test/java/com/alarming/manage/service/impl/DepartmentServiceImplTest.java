package com.alarming.manage.service.impl;

import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.service.CounsellorService;
import com.alarming.manage.service.DepartmentService;
import com.alarming.manage.vo.DepartmentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



/**
 * @author GUO
 * @Classname DepartmentServiceImplTest
 * @Description TODO
 * @Date 2021/4/5 18:33
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {

    @Autowired
    private CounsellorService counsellorService;
    @Autowired
    private DepartmentService departmentService;
    @Test
    public void findAll() {
        List<DepartmentVO> departments = departmentService.findDepartments();
        log.info(departments.toString());
//        List<Department> list =departmentService.findAll();
//        log.info(list.toString());
    }

    @Test
   public void saveDepart() {
    }
    @Test
   public void delDepart() {
    }
    @Test
    public void test(){
        Counsellor counsellor = counsellorService.getOne(1);
        log.info(counsellor.toString());
    }
}