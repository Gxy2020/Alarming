package com.alarming.manage.vo;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author GUO
 * @Classname DepartMentVO
 * @Description TODO
 * @Date 2021/4/16 14:14
 */
@Data
public class DepartmentVO {
    private int departmentId;
    private String name;
    private Integer majorNum;
    private Integer classNum;
    private String createTime;
}
