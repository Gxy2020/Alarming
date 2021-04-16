package com.alarming.manage.objectdata;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author GUO
 * @Classname SelectCourse
 * @Description TODO
 * @Date 2021/3/25 22:00
 */
@Data
@Entity
@Table(name = "t_select_course")
public class SelectCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "stu_id")
    private String stuId;
    @Column(name = "score")
    private int score;
    @Column(name = "time")
    private String time;
    @Column(name = "create_time")
    private Date create_time;

}
