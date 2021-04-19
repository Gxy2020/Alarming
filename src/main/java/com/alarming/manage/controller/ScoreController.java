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
    //查找挂科占比
    @GetMapping("/findCodeFailed")
    public ResultVO findCodeFailed(){
        List<Map<String, Object>> mapList =scoreService.findCodeFailed();
        return ResultVOUtil.success(mapList);
    }
    //通过院系查找该院学生成绩
    @GetMapping("/findByDepartmentId/{departmentId}")
    public ResultVO findByDepartmentId(@PathVariable Integer departmentId){
        List<ScoresVO> scoresVOList = scoreService.findByDepartmentId(departmentId);
        return ResultVOUtil.success(scoresVOList);
    }
    //查询班级成绩
    @GetMapping("/findByClassId/{classId}")
    public ResultVO findByClassId(@PathVariable Integer classId){
        List<ScoresVO> scoresVOList = scoreService.findByClassId(classId);
        return ResultVOUtil.success(scoresVOList);
    }

    @PostMapping("/findByDepartmentIdCodeOrClassId")
    public ResultVO findByDepartmentIdCodeOrClassId(Integer departmentId, String code, Integer classId){
        List<ScoresVO> scoresVOList = scoreService.findByDepartmentIdCodeOrClassId(departmentId, code, classId);
        return ResultVOUtil.success(scoresVOList);
    }
    //按学号查询个人成绩
    @GetMapping("/findScoreByStuId/{stuId}")
    public ResultVO findScoreByStuId(@PathVariable String stuId){
        List<ScoresVO> scoresVOList = scoreService.findScoreByStuId(stuId);
        return ResultVOUtil.success(scoresVOList);
    }
    //按学号与课程查询个人成绩
    @PostMapping("/findByStuIdAndCodeAndClassId")
    public ResultVO findByStuIdAndCodeAndClassId(String stuId,String code,Integer classId){
        List<ScoresVO> scoresVOList = scoreService.findByStuIdAndCodeAndClassId(stuId,code,classId);
        return ResultVOUtil.success(scoresVOList);
    }
}
