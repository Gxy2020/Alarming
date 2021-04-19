package com.alarming.manage.service;

import com.alarming.manage.objectdata.Course;
import com.alarming.manage.objectdata.Score;
import com.alarming.manage.vo.ScoresVO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname ScoreService
 * @Description TODO
 * @Date 2021/4/17 15:11
 */
public interface ScoreService {
    List<ScoresVO> findAll();
    List<ScoresVO>findScoreByStuId(String stuId);
    List<ScoresVO>findByStuIdAndCodeAndClassId(String studId,String code,Integer classId);


    List<ScoresVO> findByCodeOrClassId(String code, Integer classId);
    boolean saveScore(Score score);

    boolean delScore(Integer id);

    boolean updateScore(Integer id, Integer score);

    List<Map<String, Object>> findCodToAverage();

    List<Map<String, Object>> findCodeFailed();

    List<ScoresVO> findByDepartmentId(Integer departmentId);
    List<ScoresVO>findByClassId(Integer classId);
    //    Page<ScoresVO> findScoresVOPage(Integer pageNum, Integer size);
    List<ScoresVO> findByDepartmentIdCodeOrClassId(Integer departmentId,String code, Integer classId);
}
