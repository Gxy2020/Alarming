package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Course;
import com.alarming.manage.service.CourseService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GUO
 * @Classname CourseController
 * @Description TODO
 * @Date 2021/4/17 3:21
 */
@Slf4j
@Api(tags = "科目接口")
@RestController
@RequestMapping("/api/counsellor")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/findCoursePage")
    public ResultVO findCoursePage(@RequestParam(value = "pageNum" , defaultValue = "0")int pageNum,
                                   @RequestParam("pageSize")int pageSize){
        Page<Course> coursePage = courseService.findCoursePage(pageNum, pageSize);
        return ResultVOUtil.success(coursePage);
    }
}
