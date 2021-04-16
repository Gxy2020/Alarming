package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author GUO
 * @Classname TeacherDao
 * @Description TODO
 * @Date 2021/4/7 18:51
 */
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    Teacher findByUserAndPassword(String user,String password);
    @Query(value = "select class_id from t_teacher",nativeQuery = true)
    List<Integer>findAllClass();
    Teacher findByUser(String user);
}
