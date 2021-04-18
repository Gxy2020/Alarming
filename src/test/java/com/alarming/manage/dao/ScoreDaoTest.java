package com.alarming.manage.dao;

import com.alarming.manage.objectdata.Score;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author GUO
 * @Classname ScoreDaoTest
 * @Description TODO
 * @Date 2021/4/17 15:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreDaoTest {
    @Autowired
    private ScoreDao scoreDao;
    @Test
    public void findAll(){
        List<Score> all =  scoreDao.findAll();
        log.info(String.valueOf(all));

    }

}