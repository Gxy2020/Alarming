package com.alarming.manage.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname CourseDaoTest
 * @Description TODO
 * @Date 2021/4/19 0:42
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {

    @Autowired
    CourseDao courseDao;
    @Test
    public void findCodeList() {
        List<String> codeList = courseDao.findCodeList();
        log.info(codeList.toString());
    }
}