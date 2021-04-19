package com.alarming.manage.service;

import com.alarming.manage.objectdata.Message;

import java.util.List;

/**
 * @author GUO
 * @Classname MessageService
 * @Description TODO
 * @Date 2021/4/19 17:50
 */
public interface MessageService {
    boolean sendMessage(Message message);
    List<Message> findBySendId(String sendId);
    List<Message>findByReceiverId(String receiverId);
}
