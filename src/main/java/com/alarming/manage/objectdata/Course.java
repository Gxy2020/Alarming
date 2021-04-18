package com.alarming.manage.objectdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GUO
 * @Classname Course
 * @Description TODO
 * @Date 2021/3/25 21:58
 */
@Entity
@Table(name = "t_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private String createTime;

//    @JsonIgnore
//    @OneToMany(mappedBy = "course",fetch=FetchType.LAZY)
//    private List<Score>scoreList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

//    public List<Score> getScoreList() {
//        return scoreList;
//    }
//
//    public void setScoreList(List<Score> scoreList) {
//        this.scoreList = scoreList;
//    }
}
