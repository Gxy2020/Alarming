package com.alarming.manage.objectdata;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author GUO
 * @Classname Admin
 * @Description 系统管理员实体
 * @Date 2021/3/25 21:58
 */
@Data
@Entity
@Table(name = "t_admin")
public class Admin {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //用户名
    @Column(name = "user")
    private String user;
    //密码
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "create_time")
    private String createTime;
}
