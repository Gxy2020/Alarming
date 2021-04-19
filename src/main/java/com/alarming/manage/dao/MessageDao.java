package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Message;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
