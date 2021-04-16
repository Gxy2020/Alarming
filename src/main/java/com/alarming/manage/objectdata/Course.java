package com.alarming.manage.objectdata;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author GUO
 * @Classname Course
 * @Description TODO
 * @Date 2021/3/25 21:58
 */
@Data
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
    private Date createTime;
}
