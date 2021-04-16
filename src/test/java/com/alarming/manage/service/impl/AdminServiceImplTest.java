package com.alarming.manage.service.impl;

import com.alarming.manage.objectdata.Admin;
import com.alarming.manage.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GUO
 * @Classname AdminServiceImplTest
 * @Description TODO
 * @Date 2021/3/28 13:49
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public  class AdminServiceImplTest {
    @Autowired
    AdminService adminService;

    @Test
    public void Save(){
        Admin admin=new Admin();
        admin.setUser("123456");
        admin.setPassword("123456");
        boolean b = adminService.addAdmin(admin);
        log.info("添加结果:");
        log.info(String.valueOf(b));
    }

    @Test
    public void findByUserAndPassword(){
        Admin admin = adminService.findByUserAndPassword("admin", "123456");
        log.info("登录结果:admin={}",admin);
    }
}