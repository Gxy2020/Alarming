package com.alarming.manage.service;

import com.alarming.manage.objectdata.Notice;

import java.util.List;

/**
 * @author GUO
 * @Classname NoticeService
 * @Description TODO
 * @Date 2021/4/20 4:51
 */
public interface NoticeService {
    boolean saveNotice(Notice notice);
    List<Notice>findAllNotice();
    boolean delNotice(Integer id);
}
