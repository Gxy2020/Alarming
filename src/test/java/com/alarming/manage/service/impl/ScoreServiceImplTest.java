package com.alarming.manage.service.impl;

import com.alarming.manage.service.ScoreService;
import com.alarming.manage.vo.ScoresVO;
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
 * @Classname ScoreServiceImplTest
 * @Description TODO
 * @Date 2021/4/17 16:08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreServiceImplTest {
    @Autowired
    private ScoreService scoreService;
    @Test
    public void findAll() {
        List<ScoresVO> scoresVOList = scoreService.findAll();
        log.info(scoresVOList.toString());
    }
}