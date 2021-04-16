package com.alarming.manage.controller;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.service.DepartmentService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.DepartmentVO;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GUO
 * @Classname DepartmentController
 * @Description TODO
 * @Date 2021/4/13 15:00
 */
@Slf4j
@Api(tags = "院系接口")
@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/findAllDepartments")
    public ResultVO findAll(){
        List<Department> departmentList = departmentService.findAll();
        return ResultVOUtil.success(departmentList);
    }
    @GetMapping("/findDepartments")
    public ResultVO findDepartments(){
        List<DepartmentVO> departments = departmentService.findDepartments();
        return ResultVOUtil.success(departments);
    }
    @DeleteMapping("/delDepartment/{departmentId}")
    public ResultVO delDepartment(@PathVariable Integer departmentId ){
        boolean b = departmentService.delDepart(departmentId);
        return b?ResultVOUtil.success():ResultVOUtil.error(500,"删除失败");
    }
    @PostMapping("/saveDepartment")
    public ResultVO saveDepartment(Department department){
        boolean b = departmentService.saveDepart(department);
        return b?ResultVOUtil.success():ResultVOUtil.error(500,"保存失败");
    }
    @PostMapping("/updateDepartment")
    public ResultVO updateDepartment(Integer departmentId,String name){
        boolean b = departmentService.updateDepartment(departmentId, name);
        return b?ResultVOUtil.success():ResultVOUtil.error(500,"更新失败");
    }
}
