package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author GUO
 * @Classname NoticeDao
 * @Description TODO
 * @Date 2021/4/20 4:50
 */
public interface NoticeDao extends JpaRepository<Notice,Integer> {
}
