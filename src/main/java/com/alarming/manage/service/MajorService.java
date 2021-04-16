package com.alarming.manage.service;

import com.alarming.manage.objectdata.Major;

import java.util.List;

/**
 * @author GUO
 * @Classname MajorService
 * @Description TODO
 * @Date 2021/4/14 17:21
 */
public interface MajorService {
    List<Major>findAll();
    List<Major>findByDepartmentId(Integer departmentId);
}
