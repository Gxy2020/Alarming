package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

/**
 * @author GUO
 * @Classname Teacher
 * @Description TODO
 * @Date 2021/3/25 21:58
 */
@Data
@Entity
@Table(name = "t_teacher")
public class Teacher {
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

    @JsonIgnore
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    private Department tDepartment;

    @OneToOne
    @JoinColumn(name = "class_id")
    private SClass sClass;


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
//                ", tDepartment=" + tDepartment.getName() +
                ", sClass=" + sClass.getName() +
                '}';
    }
}
