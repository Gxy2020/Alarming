package com.alarming.manage.utils;
import com.alarming.manage.vo.ResultVO;
/**
 * @author
 * @Classname ResultVOUtil
 * @Description 返回工具类
 * @Date 2021/3/25 23:36
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMsg("请求成功");
        return  resultVO;
    }
    public static ResultVO success(){
        return  success(null);
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
