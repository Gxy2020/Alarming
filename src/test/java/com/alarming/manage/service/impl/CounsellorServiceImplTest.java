package com.alarming.manage.service.impl;

import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.service.CounsellorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GUO
 * @Classname CounsellorServiceImplTest
 * @Description TODO
 * @Date 2021/4/14 13:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CounsellorServiceImplTest {

    @Autowired
    private CounsellorService counsellorService;

    @Transactional
    @Test
   public void findByDepartmentOrUsernameOrPhone() {
        Department department=new Department();
        department.setDepartmentId(3);
        List<Counsellor> counsellorList = counsellorService.findByDepartmentOrUsernameOrPhone(department, "张良", "");
        log.info(counsellorList.toString());
    }
}