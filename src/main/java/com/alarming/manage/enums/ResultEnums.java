package com.alarming.manage.enums;

import lombok.Getter;

/**
 * @author GUO
 * @Classname ResultEnums
 * @Description TODO
 * @Date 2021/3/28 10:49
 */
@Getter
public enum ResultEnums {
    LOGIN_ERROR(101,"账号或密码错误");

    private Integer code;
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
