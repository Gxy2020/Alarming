package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

/**
 * @author GUO
 * @Classname Clas
 * @Description TODO
 * @Date 2021/4/5 23:06
 */
@Entity
@Table(name = "t_class")
public class SClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private String createTime;

    @ManyToOne(targetEntity = Major.class)
    @JoinColumn(name = "mc_id")
    private Major major;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "dc_id")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "sClass",fetch = FetchType.LAZY)
    private Set<Student> cStudents =new HashSet<>();


    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", majorName=" + major.getName() +
                ", departmentName=" + major.getDepartment().getName() +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Set<Student> getcStudents() {
        return cStudents;
    }

    public void setcStudents(Set<Student> cStudents) {
        this.cStudents = cStudents;
    }
}
