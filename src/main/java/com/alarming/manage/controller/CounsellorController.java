package com.alarming.manage.controller;

import com.alarming.manage.dao.DepartmentDao;
import com.alarming.manage.exception.AlarmingException;
import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.service.CounsellorService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.CounsellorVO;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GUO
 * @Classname CounsellorController
 * @Description TODO
 * @Date 2021/4/8 22:38
 */
@Slf4j
@Api(tags = "辅导员接口")
@RestController
@RequestMapping("/api/counsellor")
public class CounsellorController {
    @Autowired
    private CounsellorService counsellorService;
    @Autowired
    private DepartmentDao departmentDao;

    @PostMapping("/login")
    @ApiOperation(value = "系辅导员登录接口")
    public ResultVO login(String user, String password, HttpSession session, HttpServletRequest request) {
        Counsellor counsellor = counsellorService.findByUserAndPassword(user, password);
        if (counsellor != null) {
            log.info("请求/api/counsellor接口成功");
            session.setAttribute("User", user);
            String sting = new Date() + counsellor.getUser();
            String token = sting.replaceAll(" ", "");
            ResultVO resultVO = new ResultVO();
            resultVO.setData(token);
            Map data = new HashMap();
            data.put("token", token);
            data.put("user", counsellor);
            return ResultVOUtil.success(data);
        } else {
            return ResultVOUtil.error(101, "账户或密码错误");
        }
    }

    @GetMapping("/findCounsellorList")
    public ResultVO findAll() {
        List<CounsellorVO> counsellorList = counsellorService.findAll();
        return ResultVOUtil.success(counsellorList);
    }

    @PostMapping("/saveUser")
    public ResultVO saveUser(Counsellor counsellor, Integer departmentId) {
        boolean b = counsellorService.saveUser(counsellor, departmentId);
        log.info(String.valueOf(b));
        return b ? ResultVOUtil.success() : ResultVOUtil.error(103, "保存异常");
    }

    @GetMapping("/getOne/{id}")
    public ResultVO getOne(@PathVariable Integer id) {
        Counsellor counsellor = counsellorService.getOne(id);
        return counsellor == null ? ResultVOUtil.error(104, "请求错误") : ResultVOUtil.success(counsellor);
    }

    @DeleteMapping("/delUser/{id}")
    public ResultVO delUser(@PathVariable Integer id) {
        boolean b = counsellorService.delUser(id);
        return b ? ResultVOUtil.success() : ResultVOUtil.error(404, "已删除");
    }

    @GetMapping("/findCounsellors")
    public ResultVO findCounsellors() {
        List<Counsellor> counsellorList = counsellorService.findCounsellors();
        return ResultVOUtil.success(counsellorList);
    }

    @PostMapping(value = "/query")
    public ResultVO query(Integer departmentId, String username, String phone) {

        log.info("departmentId={},username={},phone={}", departmentId, username, phone);
        if (departmentId == null) {
            if (username.equals("") & phone.equals("")) {
                List<Counsellor> counsellorList = counsellorService.findCounsellors();
                log.info("查询参数全为空");
                return ResultVOUtil.success(counsellorList);
            } else {
                log.info("院系为空");
                List<Counsellor> counsellorList = counsellorService.findByUsernameOrPhone(username, phone);
                return ResultVOUtil.success(counsellorList);
            }
        } else {
            Department one = departmentDao.getOne(departmentId);
            List<Counsellor> counsellorList = counsellorService.findByDepartmentOrUsernameOrPhone(one, username, phone);
            return ResultVOUtil.success(counsellorList);
        }
    }
}
