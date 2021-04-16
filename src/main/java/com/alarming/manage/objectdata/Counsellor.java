package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author GUO
 * @Classname Counseller
 * @Description TODO
 * @Date 2021/4/8 21:05
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
@Entity
@Table(name = "t_counsellor")
public class Counsellor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "sex")
    private String sex;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "create_time")
    private String createTime;
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "cd_id")
    private Department department;

    @Override
    public String toString() {
        return "Counsellor{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", create_time=" + createTime +
                ", department=" + department.getName() +
                '}';
    }
}
