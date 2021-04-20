package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Counsellor;
import com.alarming.manage.objectdata.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GUO
 * @Classname CounsellorDao
 * @Description TODO
 * @Date 2021/4/8 21:19
 */
public interface CounsellorDao extends JpaRepository<Counsellor,Integer> , JpaSpecificationExecutor<Counsellor> {
    Counsellor findByUserAndPassword(String user,String password);
    Counsellor findByUser(String user);
    //更新操作
    @Transactional
    @Modifying
    @Query("update Counsellor set password=?1,username=?2,sex=?3,phone=?4,email=?5 where id=?6")
    void updateCounsellor(String password,String username,String sex,String phone,String email,Integer id);
    List<Counsellor>findByDepartment(Department department);

}
