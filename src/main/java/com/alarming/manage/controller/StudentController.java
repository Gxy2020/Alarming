package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.StudentService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GUO
 * @Classname StudentController
 * @Description TODO
 * @Date 2021/4/7 21:44
 */
@Slf4j
@Api(tags = "学生接口")
@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "学生登录接口")
    @PostMapping("/login")
    public ResultVO login(String user , String password, HttpSession session, HttpServletRequest request){
        Student student = studentService.findByUserAndPassword(user, password);
        if (student!=null){
            log.info("请求/api/student接口成功");
            session.setAttribute("loginUser", user);
            String sting=new Date()+user;
            String token=sting.replaceAll(" ","");
            ResultVO resultVO=new ResultVO();
            resultVO.setData(token);
            Map data=new HashMap();
            data.put("token",token);
            data.put("user",student);
            return ResultVOUtil.success(data);
        }else {
            return ResultVOUtil.error(101,"账户或密码错误");
        }
    }

    @GetMapping("/findStudentPage")
    public ResultVO findStudentPage(@RequestParam(value = "pageNum" , defaultValue = "0")int pageNum,
                                    @RequestParam("pageSize")int pageSize,String str){
        Page<Student> studentPage = studentService.findStudentPage(pageNum,pageSize,str);
        return ResultVOUtil.success(studentPage);

    }
}
