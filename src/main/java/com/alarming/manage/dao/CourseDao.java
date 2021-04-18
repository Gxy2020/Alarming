package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname CourseDao
 * @Description TODO
 * @Date 2021/4/17 3:14
 */
public interface CourseDao extends JpaRepository<Course,Integer> , JpaSpecificationExecutor<Course> {
    Course findByNameOrCode(String name,String code);
    Course findByCode(String code);
    Integer countAllBy();
    //查询所有课程代码
    @Query(value = "select code from t_course",nativeQuery = true)
    List<String>findCodeList();
}
