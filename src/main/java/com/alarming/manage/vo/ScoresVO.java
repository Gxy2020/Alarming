package com.alarming.manage.vo;

import lombok.Data;

/**
 * @author GUO
 * @Classname ScoresVO
 * @Description TODO
 * @Date 2021/4/17 14:56
 */
@Data
public class ScoresVO {
    private Integer id;
    private String stuId;
    private String studentName;
    private String courseName;
    private String departmentName;
    private String className;
    private Integer score;
    private String time;
}
