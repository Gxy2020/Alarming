package com.alarming.manage.service.impl;

import com.alarming.manage.dao.NoticeDao;
import com.alarming.manage.objectdata.Notice;
import com.alarming.manage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname NoticeServiceImpl
 * @Description TODO
 * @Date 2021/4/20 4:53
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public boolean saveNotice(Notice notice) {
        noticeDao.save(notice);
        return true;
    }

    @Override
    public List<Notice> findAllNotice() {
        List<Notice> noticeList = noticeDao.findAll();
        return noticeList;
    }

    @Override
    public boolean delNotice(Integer id) {
        noticeDao.deleteById(id);
        return true;
    }
}
