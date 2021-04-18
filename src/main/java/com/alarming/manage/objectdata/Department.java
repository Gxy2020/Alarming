package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

/**
 * @author GUO
 * @Classname Department
 * @Description TODO
 * @Date 2021/4/5 14:40
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "t_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private String createTime;

    @JsonIgnore
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<Major> majors=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "departments",fetch =FetchType.LAZY )
    private Set<Student>dStudents=new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "tDepartment",fetch =FetchType.LAZY)
    private Set<Teacher>teachers=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<Counsellor>counsellors=new HashSet<>();

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime + '}';
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    public Set<Student> getdStudents() {
        return dStudents;
    }

    public void setdStudents(Set<Student> dStudents) {
        this.dStudents = dStudents;
    }

    public Set<Major> getMajors() {
        return majors;
    }

    public void setMajors(Set<Major> majors) {
        this.majors = majors;
    }
}
