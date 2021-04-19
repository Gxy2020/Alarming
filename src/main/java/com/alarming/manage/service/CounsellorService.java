package com.alarming.manage.service;

import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import com.alarming.manage.vo.CounsellorVO;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname CounsellorService
 * @Description TODO
 * @Date 2021/4/8 22:32
 */
public interface CounsellorService {
    Counsellor findByUserAndPassword(String user,String password);
    List<CounsellorVO> findAll();
    boolean saveUser(Counsellor counsellor,Integer departmentId);
    boolean findByUser(String user);
    boolean delUser(Integer id);
    Counsellor getOne(Integer id);
    List<Counsellor>findCounsellors();
    List<Counsellor>findByUsernameOrPhone(String username, String phone);
    List<Counsellor>findByDepartmentOrUsernameOrPhone(Department department, String username, String phone);
    Map getByUser(String user);
}
