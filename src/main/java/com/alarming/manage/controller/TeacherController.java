package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Teacher;
import com.alarming.manage.service.TeacherService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname TeacherController
 * @Description TODO
 * @Date 2021/4/8 18:16
 */
@Slf4j
@Api(tags = "班主任接口")
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "教师登录接口")
    @PostMapping("/login")
    public ResultVO login(String user, String password, HttpSession session, HttpServletRequest request) {
        Teacher teacher = teacherService.findByUserAndPassword(user, password);
        if (teacher != null) {
            log.info("请求/api/admin接口成功");
            session.setAttribute("loginUser", teacher.getUser());
            String sting = new Date() + user;
            String token = sting.replaceAll(" ", "");
            ResultVO resultVO = new ResultVO();
            resultVO.setData(token);
            Map data = new HashMap();
            data.put("token", token);
            data.put("user", teacher);
            return ResultVOUtil.success(data);
        } else {
            return ResultVOUtil.error(101, "账户或密码错误");
        }
    }

    @GetMapping("/findTeacherList")
    public ResultVO findTeacherList() {
        List<Teacher> teacherList = teacherService.findAll();
        return ResultVOUtil.success(teacherList);
    }
    @PostMapping("/saveTeacher")
    public ResultVO saveTeacher(Teacher teacher,Integer departmentId,Integer classId){
        Teacher user = teacherService.findByUser(teacher.getUser());
        if (user!=null){
            log.info("添加失败,用户名已存在,user={}",user.getUser());
            return ResultVOUtil.error(500,"添加失败,用户已存在");
        }else {
        boolean b = teacherService.saveTeacher(teacher, departmentId, classId);
        return b?ResultVOUtil.success():ResultVOUtil.error(105,"保存失败");
        }
    }

    @DeleteMapping("/delTeacher/{id}")
    public ResultVO delTeacher(@PathVariable Integer id) {
        boolean b = teacherService.delTeacher(id);
        return b ? ResultVOUtil.success() : ResultVOUtil.error(105, "删除失败");
    }
    //查询教师是否存在
    @GetMapping("/findByUser/{user}")
    public ResultVO findByUser(@PathVariable String user){
        Teacher teacher = teacherService.findByUser(user);
        if (teacher==null){
            return ResultVOUtil.success();
        }else {
            return ResultVOUtil.error(500,"用户名已存在");
        }
    }
    //获取教师信息
    @GetMapping("/getUser/{user}")
    public ResultVO getUser(@PathVariable String user){
        Teacher teacher = teacherService.findByUser(user);
        return ResultVOUtil.success(teacher);
    }
}
