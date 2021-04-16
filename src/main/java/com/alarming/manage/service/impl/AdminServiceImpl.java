package com.alarming.manage.service.impl;

import com.alarming.manage.dao.AdminDao;
import com.alarming.manage.enums.ResultEnums;
import com.alarming.manage.exception.AlarmingException;
import com.alarming.manage.objectdata.Admin;
import com.alarming.manage.service.AdminService;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname AdminServiceImpl
 * @Description TODO
 * @Date 2021/3/26 10:46
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private  AdminDao adminDao;

    @Override
    public Admin findByUserAndPassword(String user , String password) {
        Admin admin = adminDao.findByUserAndPassword(user, password);
        if (admin!=null){
         log.info("【用户登录】登录成功，admin={}",admin);
         return admin;
        }else {
            log.info(String.valueOf(admin==null));
            log.info("【用户登录】账户或密码错误，user={},password={}",user,password);
            return null;
        }
    }
    @Override
    public boolean addAdmin(Admin admin){
        List<Admin> byUser = adminDao.findByUser(admin.getUser());
        if (byUser.size()!=0){
            return false;
        }else {
        String s = DateUtil.ToString();
        admin.setCreateTime(s);
        adminDao.save(admin);
            return true;
        }
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> adminList = adminDao.findAll();
        return adminList;
    }

    @Override
    public List<Admin> findByUser(String user) {
        List<Admin> adminList = adminDao.findByUser(user);
        return adminList;
    }
}
