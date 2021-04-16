package com.alarming.manage.vo;

import lombok.Data;

/**
 * @author GUO
 * @Classname ClassVO
 * @Description TODO
 * @Date 2021/4/16 22:02
 */
@Data
public class ClassVO {
    private Integer classId;
    private String name;
    private String departmentName;
    private String majorName;
    private Integer studentNum;
    private String createName;
}
