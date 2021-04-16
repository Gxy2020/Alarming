package com.alarming.manage.controller;

import com.alarming.manage.enums.ResultEnums;
import com.alarming.manage.exception.AlarmingException;
import com.alarming.manage.objectdata.Admin;
import com.alarming.manage.service.AdminService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname AdminController
 * @Description 系统管理员接口
 * @Date 2021/3/26 10:56
 */
@Slf4j
@Api(tags = "系统管理员接口")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "系统管理员登录接口")
    @PostMapping("/login")
    public ResultVO login(String user, String password, HttpSession session, HttpServletRequest request) {
        Admin admin = adminService.findByUserAndPassword(user, password);
        if (admin != null) {
            log.info("请求/api/admin接口成功");
            session.setAttribute("loginUser", admin.getUser());
            String sting = new Date() + user;
            String token = sting.replaceAll(" ", "");
            ResultVO resultVO = new ResultVO();
            resultVO.setData(token);
            Map data = new HashMap();
            data.put("token", token);
            data.put("user", admin);
            return ResultVOUtil.success(data);
        } else {
            return ResultVOUtil.error(101, "账户或密码错误");
        }
    }

    @GetMapping("/findAdminList")
    public ResultVO findAll() {
        List<Admin> adminList = adminService.findAll();
        return ResultVOUtil.success(adminList);
    }

    @PostMapping("/add")
    public ResultVO add(Admin admin) {
        boolean b = adminService.addAdmin(admin);
        return b ? ResultVOUtil.success():ResultVOUtil.error(103,"添加失败");
    }

    @GetMapping("/findByUser")
    public ResultVO findByUser(String user) {
        List<Admin> adminList = adminService.findByUser(user);
        return adminList == null ?  ResultVOUtil.success():ResultVOUtil.error(102, "用户名已存在") ;
    }
}

