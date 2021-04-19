package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author GUO
 * @Classname ScoreDao
 * @Description TODO
 * @Date 2021/4/17 15:23
 */
public interface ScoreDao extends JpaRepository<Score,Integer>, JpaSpecificationExecutor<Score> {
    List<Score>findByCode(String code);
    List<Score>findByClassId(Integer classId);
    List<Score>findByDepartmentId(Integer departmentId);
    List<Score>findByStuId(String studId);
    List<Score>findByStuIdAndCodeAndClassId(String studId,String code,Integer classId);
}
