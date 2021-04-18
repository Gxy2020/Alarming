package com.alarming.manage.dao;

import com.alarming.manage.objectdata.SClass;
import com.alarming.manage.objectdata.Student;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author GUO
 * @Classname StudentDao
 * @Description TODO
 * @Date 2021/3/31 23:12
 */
public interface StudentDao extends JpaRepository<Student,Integer> , JpaSpecificationExecutor<Student> {
    //查找用户和密码
    Student findByUserAndPassword(String user,String password);

//    List<Student>findByDepartments(Department department);
    //通过学号查找该学生
    Student findByUser(String user);
    //按照班级id查找学生人数
    @Query(value = "SELECT count(sc_id) from t_student where sc_id=?1",nativeQuery = true)
    Integer findCountByClassId(Integer classId);

    //通过班级id查询学生
    @Query(value = "select * from t_student where sc_id=?1",nativeQuery = true)
    List<Student>findBysClass(Integer classId);
    @Query(value = "select * from t_student where sd_id=?1",nativeQuery = true)
    List<Student>findByDepartmentId(Integer departmentId);
    Integer countAllBy();
}
