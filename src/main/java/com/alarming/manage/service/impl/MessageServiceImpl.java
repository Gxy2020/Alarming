package com.alarming.manage.service.impl;

import com.alarming.manage.dao.MessageDao;
import com.alarming.manage.objectdata.Message;
import com.alarming.manage.service.MessageService;
import com.alarming.manage.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname MessageServiceImpl
 * @Description TODO
 * @Date 2021/4/19 17:50
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public boolean sendMessage(Message message) {
            message.setCreateTime(DateUtil.ToString());
            messageDao.save(message);
            return true;
    }

    @Override
    public List<Message> findBySendId(String sendId) {
        List<Message> messageList = messageDao.findBySendId(sendId);
        return messageList;
    }

    @Override
    public List<Message> findByReceiverId(String receiverId) {
        List<Message> messageList = messageDao.findByReceiverId(receiverId);
        return messageList;
    }

    @Override
    public void updateMessages(String source, Integer id) {
        messageDao.updateMessages(source, id);
    }
}
