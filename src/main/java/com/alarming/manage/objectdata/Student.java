package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @author GUO
 * @Classname Student
 * @Description TODO
 * @Date 2021/3/25 21:57
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "t_student")
public class Student {
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

    @Column(name = "year")
    private String year;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;


    @Column(name = "create_time")
    private String  createTime;


    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "sd_id")
    private Department departments;

    @ManyToOne(targetEntity = Major.class)
    @JoinColumn(name = "sm_id")
    private Major majors;

    @ManyToOne(targetEntity = SClass.class)
    @JoinColumn(name = "sc_id")
    private SClass sClass;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", year='" + year + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", create_time=" + createTime +
                ", department=" + departments.getName() +
                ", major=" + majors.getName() +
                ", sClass=" + sClass.getName() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public Major getMajors() {
        return majors;
    }

    public void setMajors(Major majors) {
        this.majors = majors;
    }

    public SClass getsClass() {
        return sClass;
    }

    public void setsClass(SClass sClass) {
        this.sClass = sClass;
    }
}
