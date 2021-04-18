package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Score;
import com.alarming.manage.service.ScoreService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import com.alarming.manage.vo.ScoresVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname ScoreCountroller
 * @Description TODO
 * @Date 2021/4/17 15:10
 */
@Slf4j
@Api(tags = "成绩接口")
@RestController
@RequestMapping("/api/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    //查询所有成绩
    @GetMapping("/findAll")
    public ResultVO findAll(){
        List<ScoresVO> scoresVOList = scoreService.findAll();
        return ResultVOUtil.success(scoresVOList);
    }
    //按课程或者班级条件查询成绩
    @PostMapping("/queryScore")
    public ResultVO queryScore(String code, Integer classId){
        List<ScoresVO> scoresVOList = scoreService.findByCodeOrClassId(code, classId);
        return ResultVOUtil.success(scoresVOList);
    }
    //添加成绩
    @PostMapping("/saveScore")
    public ResultVO saveScore(Score score){
        boolean b = scoreService.saveScore(score);
        return b? ResultVOUtil.success():ResultVOUtil.error(500,"保存错误");

    }
    //删除成绩
    @DeleteMapping("/delScore/{id}")
    public ResultVO delScore(@PathVariable Integer id){
        boolean b = scoreService.delScore(id);
        return b? ResultVOUtil.success():ResultVOUtil.error(500,"删除错误");
    }
    //更新成绩
    @PostMapping("/updateScore")
    public ResultVO updateScore(Integer id,Integer score){
        scoreService.updateScore(id,score);
        return ResultVOUtil.success();
    }
    //查询所有各科平均数
    @GetMapping("/findCodToAverage")
    public ResultVO findCodToAverage(){
        List<Map<String, Object>> mapList = scoreService.findCodToAverage();
        return ResultVOUtil.success(mapList);
    }
    @GetMapping("/findCodeFailed")
    public ResultVO findCodeFailed(){
        List<Map<String, Object>> mapList =scoreService.findCodeFailed();
        return ResultVOUtil.success(mapList);
    }
}
