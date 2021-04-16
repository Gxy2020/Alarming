package com.alarming.manage.service;

import com.alarming.manage.objectdata.Admin;

import java.util.List;

/**
 * @author GUO
 * @Classname AdminService
 * @Description TODO
 * @Date 2021/3/26 10:44
 */
public interface AdminService {
    Admin findByUserAndPassword(String user,String password);
    boolean  addAdmin(Admin admin);
    List<Admin>findAll();
    List<Admin> findByUser(String user);
}
