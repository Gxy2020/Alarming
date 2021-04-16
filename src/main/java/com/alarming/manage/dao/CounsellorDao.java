package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Counsellor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author GUO
 * @Classname CounsellorDao
 * @Description TODO
 * @Date 2021/4/8 21:19
 */
public interface CounsellorDao extends JpaRepository<Counsellor,Integer> , JpaSpecificationExecutor<Counsellor> {
    Counsellor findByUserAndPassword(String user,String password);
    Counsellor findByUser(String user);
}
