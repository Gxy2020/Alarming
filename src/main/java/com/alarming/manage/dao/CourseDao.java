package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author GUO
 * @Classname CourseDao
 * @Description TODO
 * @Date 2021/4/17 3:14
 */
public interface CourseDao extends JpaRepository<Course,Integer> , JpaSpecificationExecutor<Course> {
}
