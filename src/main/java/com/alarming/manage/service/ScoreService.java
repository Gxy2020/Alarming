package com.alarming.manage.service;

import com.alarming.manage.objectdata.Course;
import com.alarming.manage.objectdata.Score;
import com.alarming.manage.vo.ScoresVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author GUO
 * @Classname ScoreService
 * @Description TODO
 * @Date 2021/4/17 15:11
 */
public interface ScoreService {
    List<ScoresVO>findAll();
    List<ScoresVO>findByCodeOrClassId(String code,Integer classId);
    boolean saveScore(Score score);
    boolean delScore(Integer id);
    boolean updateScore(Integer id,Integer score);
//    Page<ScoresVO> findScoresVOPage(Integer pageNum, Integer size);
}
