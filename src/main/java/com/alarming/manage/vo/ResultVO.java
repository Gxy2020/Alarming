package com.alarming.manage.vo;

import lombok.Data;

/**
 * @author GUO
 * @Classname ResultVO
 * @Description Http请求返回的最外层对象
 * @Date 2021/3/25 23:36
 */
@Data
//@ApiModel(description = "返回值信息")
public class ResultVO<T> {
    /*状态码*/
//    @ApiModelProperty("状态码")
    private  Integer code;
    /*提示信息*/
//    @ApiModelProperty("提示信息")
    private String msg;
    /*具体内容*/
//    @ApiModelProperty("数据信息")
    private T data;
}
