package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

/**
 * @author GUO
 * @Classname Major
 * @Description TODO
 * @Date 2021/4/5 14:50
 */
@Entity
@Table(name = "t_major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private int majorId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private String createTime;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "dm_id")
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "major",fetch = FetchType.LAZY)
    private Set<SClass> sClasses =new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "majors",fetch = FetchType.LAZY)
    private Set<Student> mStudents=new HashSet<>();

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", departmentName=" + department.getName() +
                '}';
    }


    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<SClass> getsClasses() {
        return sClasses;
    }

    public void setsClasses(Set<SClass> sClasses) {
        this.sClasses = sClasses;
    }

    public Set<Student> getmStudents() {
        return mStudents;
    }

    public void setmStudents(Set<Student> mStudents) {
        this.mStudents = mStudents;
    }
}
