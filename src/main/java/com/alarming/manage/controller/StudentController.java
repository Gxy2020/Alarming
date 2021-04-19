package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.StudentService;
import com.alarming.manage.utils.PageModel;
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
import java.util.List;
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
    @PostMapping("/saveStudent")
    public ResultVO saveStudent(Student student,Integer departmentId,Integer classId,Integer majorId){
        boolean b = studentService.saveStudent(student, departmentId, classId, majorId);
        return b? ResultVOUtil.success():ResultVOUtil.error(500,"保存错误");
    }
    @DeleteMapping("/delStudent/{id}")
    public ResultVO delStudent(@PathVariable Integer id){
        boolean b = studentService.delStudent(id);
        return b? ResultVOUtil.success():ResultVOUtil.error(500,"删除失败");
    }
    @PostMapping("/findByDepartmentIdOrClassId")
    public ResultVO findByDepartmentIdOrClassId(Integer departmentId, Integer classId){
        List<Student> studentList = studentService.findByDepartmentIdOrClassId(departmentId, classId);
        return ResultVOUtil.success(studentList);
    }
    @GetMapping("/findStudentCount")
    public ResultVO findStudentCount(){
        Integer studentCount = studentService.findStudentCount();
        return ResultVOUtil.success(studentCount);
    }
    //院系分页查询
    @GetMapping("/findDepartmentStudentPage")
    public ResultVO findDepartmentStudentPage(@RequestParam(value = "pageNum" , defaultValue = "1")int pageNum,
                                    @RequestParam("pageSize")int pageSize,@RequestParam("departmentId") Integer departmentId){
        Map studentPage = studentService.findDepartmentStudentPage(pageNum, pageSize, departmentId);
        return ResultVOUtil.success(studentPage);
    }
    //班级分页查询
    @GetMapping("/findClassStudentPage")
    public ResultVO findClassStudentPage(@RequestParam(value = "pageNum" , defaultValue = "1")int pageNum,
                                         @RequestParam("pageSize")int pageSize,@RequestParam("classId") Integer classId){

        Map map = studentService.findClassStudentPage(pageNum, pageSize, classId);
        return ResultVOUtil.success(map);
    }
    //按学号查询个人信息
    @GetMapping("/findByUser/{user}")
    public ResultVO findByUser(@PathVariable String user){
        Student student = studentService.findByUser(user);
        return ResultVOUtil.success(student);
    }
}
