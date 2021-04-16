package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author
 * @Classname AdminDao
 * @Description 管理员dao层
 * @Date 2021/3/25 22:24
 */
public interface AdminDao extends JpaRepository<Admin,Integer> {
    //查找用户和密码
    Admin findByUserAndPassword(String user,String password);
    //通过用户名查找用户
    List<Admin>findByUser(String username);
}
