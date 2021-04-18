package com.alarming.manage.objectdata;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;

/**
 * @author GUO
 * @Classname Score
 * @Description TODO
 * @Date 2021/4/17 15:16
 */
@Data
@Entity
@Table(name = "t_select_course")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "course_code")
    private String code;
    @Column(name = "stu_id")
    private String stuId;
    @Column(name = "score")
    private Integer score;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "time")
    private String time;
    @Column(name = "create_time")
    private String createTime;
}
