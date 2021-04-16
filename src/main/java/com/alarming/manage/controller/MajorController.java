package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Major;
import com.alarming.manage.service.MajorService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GUO
 * @Classname MajorCuntroller
 * @Description TODO
 * @Date 2021/4/14 17:23
 */
@Slf4j
@Api(tags = "专业接口")
@RestController
@RequestMapping("/api/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping("/findMajors")
    public ResultVO findMajors() {
        List<Major> majorList = majorService.findAll();
        return ResultVOUtil.success(majorList);
    }

    @GetMapping("/findByDepartmentId/{departmentId}")
    public ResultVO findByDepartmentId(@PathVariable Integer departmentId) {
        if (departmentId == null) {
            List<Major> majorList = majorService.findAll();
            return ResultVOUtil.success(majorList);
        } else {
            List<Major> majorList = majorService.findByDepartmentId(departmentId);
            return ResultVOUtil.success(majorList);
        }
    }
}
