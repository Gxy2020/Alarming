package com.alarming.manage.controller;

import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.service.SClassService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GUO
 * @Classname ClassController
 * @Description TODO
 * @Date 2021/4/14 18:11
 */
@Slf4j
@Api(tags = "班级接口")
@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private SClassService sClassService;
    @GetMapping("/findClassList")
    public ResultVO findClassList(){
        List<SClass> classList = sClassService.findAll();
        return ResultVOUtil.success(classList);
    }

    /**
     * 添加班主任,查询没有班主任的班级
     * @param departmentId
     * @return
     */
    @GetMapping("/findByDepartmentId/{departmentId}")
    public ResultVO findByDepartmentId(@PathVariable Integer departmentId){
        List<SClass> classList = sClassService.findByDepartmentId(departmentId);
        return ResultVOUtil.success(classList);
    }
    @GetMapping("/findClassList/{departmentId}")
    public ResultVO findClassList(@PathVariable Integer departmentId){
        List<SClass> classList = sClassService.findByDepartment(departmentId);
        return ResultVOUtil.success(classList);
    }
}
