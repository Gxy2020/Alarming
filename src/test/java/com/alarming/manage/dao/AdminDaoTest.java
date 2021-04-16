package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Admin;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author
 * @Classname AdminDaoTest
 * @Description 管理员dao测试类
 * @Date 2021/3/25 22:32
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void testLog(){
        log.debug("debug...");
        log.info("info...");
        String name="admin";
        String password="123456";
        log.info("name:"+name+"password:"+password);
        log.info("-----");
        log.info("name:{},password:{}",name,password);
        log.error("error...");
    }
    //添加系统管理员用户
    @Test
    public void saveAdmin(){
        Admin admin = new Admin();
        admin.setUser("admin_root");
        admin.setPassword("admin123456");
        Admin result = adminDao.save(admin);
        Assert.assertNotNull(result);
    }
    //登录测试
    @Test
    public void testLogin(){
        Admin admin = adminDao.findByUserAndPassword("admin", "admin123456");
        if (admin==null){
            log.info("登陆失败");
        }else {
            log.info("登录成功");
            log.info(admin.toString());
        }
    }

    @Test
    public void findByUsername(){
        List<Admin> adminRoot = adminDao.findByUser("admin");
        log.info(adminRoot.toString());
    }
    @Test
    public void testDel(){
       adminDao.deleteById(1);
    }
    @Test
    public void testDate(){
        Admin admin=new Admin();
        admin.setUser("root");
        admin.setPassword("123456");
        String s = DateUtil.ToString();
        log.info(s);
    }
    @Test
    public void testUpdate(){
        Admin admin = adminDao.getOne(5);
        admin.setUser("gxy123");
        admin.setPassword("gxy123");
        adminDao.save(admin);
    }
}