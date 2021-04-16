package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Department;
import com.alarming.manage.objectdata.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author GUO
 * @Classname MajorDaO
 * @Description TODO
 * @Date 2021/4/5 15:00
 */
public interface MajorDao extends JpaRepository<Major,Integer>{
    //查询所以专业
    List<Major>findAll();
    //按名字查找
    Major findByName(String name);
    //按院系查找
    List<Major>findByDepartment(Department department);
    //根据院系id查询所在的专业数目
    @Query(value = "SELECT COUNT(dm_id) FROM t_major WHERE dm_id=?1",nativeQuery = true)
    Integer findMajorNum(Integer departmentId);

}
