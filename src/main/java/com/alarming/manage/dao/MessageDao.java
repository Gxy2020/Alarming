package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GUO
 * @Classname MessageDao
 * @Description TODO
 * @Date 2021/4/19 17:49
 */
public interface MessageDao extends JpaRepository<Message,Integer> {
    List<Message>findBySendId(String sendId);
    List<Message>findByReceiverId(String receiverId);
    @Modifying
    @Transactional
    @Query("update Message set source=?1 where id=?2")
    void updateMessages(String source,Integer id);
}
