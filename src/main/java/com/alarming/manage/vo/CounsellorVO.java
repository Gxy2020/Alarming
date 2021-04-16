package com.alarming.manage.vo;

import lombok.Data;

/**
 * @author GUO
 * @Classname CounsellorVo
 * @Description TODO
 * @Date 2021/4/13 11:04
 */
@Data
public class CounsellorVO {
    private int id;
    private String user;
    private String password;
    private String username;
    private String sex;
    private String departmentName;
    private String phone;
    private String email;
    private String createTime;
}
