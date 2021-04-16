package com.alarming.manage.exception;

import com.alarming.manage.enums.ResultEnums;

/**
 * @author GUO
 * @Classname AlarmingException
 * @Description TODO
 * @Date 2021/4/7 20:23
 */
public class AlarmingException extends RuntimeException {
    private Integer code;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public AlarmingException(ResultEnums resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
    public AlarmingException(Integer code,String message){
        super(message);
        this.code=code;
    }
}
