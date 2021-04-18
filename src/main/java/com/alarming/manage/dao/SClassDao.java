package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.SClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname SClassDao
 * @Description TODO
 * @Date 2021/4/6 22:40
 */
public interface SClassDao extends JpaRepository<SClass,Integer>, JpaSpecificationExecutor<SClass> {

    @Query(value = "select class_name ,class_id from t_class where mc_id=?1" ,nativeQuery = true)
    List<Map<String,Object>>findByMajorId(Integer majorId);

    List<SClass>findByDepartment(Department department);

    SClass findByName(String name);

    @Query(value = "select class_id from t_class where dc_id=?1",nativeQuery = true)
    List<Integer>findByDepartmentId(Integer departmentId);

    @Query(value = "select class_id from t_class",nativeQuery = true)
    List<Integer>findClassId();
    //根据List的id的查询班级
    @Query(value = "select * from t_class where class_id in ?1",nativeQuery = true)
    List<SClass> findList(List<Integer> classId);
    //根据院系id查询所在的班级数目
    @Query(value = "SELECT COUNT(dc_id) FROM t_class WHERE dc_id=?1",nativeQuery = true)
    Integer findClassNum(Integer departmentId);
    Integer countAllBy();
}
