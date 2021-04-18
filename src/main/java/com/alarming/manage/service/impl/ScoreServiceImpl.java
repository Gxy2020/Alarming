package com.alarming.manage.service.impl;

import com.alarming.manage.dao.CourseDao;
import com.alarming.manage.dao.ScoreDao;
import com.alarming.manage.dao.StudentDao;
import com.alarming.manage.objectdata.Course;
import com.alarming.manage.objectdata.Score;
import com.alarming.manage.objectdata.Student;
import com.alarming.manage.service.ScoreService;
import com.alarming.manage.utils.DateUtil;
import com.alarming.manage.vo.ScoresVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * @author GUO
 * @Classname ScoreServiceImpl
 * @Description TODO
 * @Date 2021/4/17 15:13
 */
@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<ScoresVO> findAll() {
        List<Score> scoreList = scoreDao.findAll();
        List<ScoresVO> scoresVOList = scoresToScoresVO(scoreList);
        return scoresVOList;
    }

    @Override
    public List<ScoresVO> findByCodeOrClassId(String code, Integer classId) {
        if (code.length() != 0 & classId != null) {
            log.info(code, classId);
            Specification<Score> specification = new Specification<Score>() {
                @Override
                public Predicate toPredicate(Root<Score> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    Path<Object> p1 = root.get("code");
                    Path<Object> p2 = root.get("classId");
                    Predicate equal = criteriaBuilder.equal(p1, code);
                    Predicate equal1 = criteriaBuilder.equal(p2, classId);
                    Predicate and = criteriaBuilder.and(equal, equal1);
                    return and;
                }
            };
            List<Score> scoreList = scoreDao.findAll(specification);
            List<ScoresVO> scoresVOList = scoresToScoresVO(scoreList);
            return scoresVOList;
        }
        if (code.equals("") & classId != null) {
            log.info(code, classId);
            List<Score> scoreList = scoreDao.findByClassId(classId);
            List<ScoresVO> scoresVOList = scoresToScoresVO(scoreList);
            return scoresVOList;
        }
        if (code.length() != 0 & classId == null) {
            log.info(code, classId);
            List<Score> scoreList = scoreDao.findByCode(code);
            List<ScoresVO> scoresVOList = scoresToScoresVO(scoreList);
            return scoresVOList;
        } else {
            log.info(code, classId);
            List<Score> scoreList = scoreDao.findAll();
            List<ScoresVO> scoresVOList = scoresToScoresVO(scoreList);
            return scoresVOList;
        }
    }

    @Override
    public boolean saveScore(Score score) {
        Specification<Score>specification=new Specification<Score>() {
            @Override
            public Predicate toPredicate(Root<Score> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Object> code = root.get("code");
                Path<Object> stuId = root.get("stuId");
                Predicate a1 = criteriaBuilder.equal(code, score.getCode());
                Predicate a2 = criteriaBuilder.equal(stuId, score.getStuId());
                Predicate and = criteriaBuilder.and(a1, a2);
                return and;
            }
        };
        List<Score> scores = scoreDao.findAll(specification);
        if (scores!=null&&!scores.isEmpty()){
            log.info(String.valueOf(scores.size()),!scores.isEmpty());
            log.info("已存在,添加失败,scores={}",scores);
        return false;
        }else {
            Student student = studentDao.findByUser(score.getStuId());
            score.setClassId(student.getsClass().getClassId());
            score.setDepartmentId(student.getDepartments().getDepartmentId());
            score.setCreateTime(DateUtil.ToString());
            scoreDao.save(score);
            return true;
        }
    }


    @Override
    public boolean delScore(Integer id) {
        Score score = scoreDao.getOne(id);
        if (score == null) {
            return false;
        }else {
            scoreDao.deleteById(id);
            return true;
        }
    }

    @Override
    public boolean updateScore(Integer id, Integer score) {
        Score one = scoreDao.getOne(id);
        one.setScore(score);
        scoreDao.save(one);
        return true;
    }

    //对象转换方法
    public List<ScoresVO> scoresToScoresVO(List<Score> scoreList) {
        List list = new ArrayList();
        for (Score score : scoreList) {
            Course code = courseDao.findByCode(score.getCode());
            Student student = studentDao.findByUser(score.getStuId());
            ScoresVO scoresVO = new ScoresVO();
            scoresVO.setId(score.getId());
            scoresVO.setStuId(score.getStuId());
            scoresVO.setStudentName(student.getUsername());
            scoresVO.setDepartmentName(student.getDepartments().getName());
            scoresVO.setClassName(student.getsClass().getName());
            scoresVO.setCourseName(code.getName());
            scoresVO.setScore(score.getScore());
            scoresVO.setTime(score.getTime());
            list.add(scoresVO);
        }
        return list;
    }
}
