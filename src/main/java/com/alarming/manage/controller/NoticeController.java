package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Notice;
import com.alarming.manage.service.NoticeService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GUO
 * @Classname NoticeController
 * @Description TODO
 * @Date 2021/4/20 4:56
 */
@Slf4j
@Api(tags = "消息接口")
@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/findAllNotice")
    public ResultVO findAllNotice(){
        List<Notice> noticeList =noticeService.findAllNotice();
        return ResultVOUtil.success(noticeList);
    }
    @PostMapping("/saveNotice")
    public ResultVO saveNotice(Notice notice){
        noticeService.saveNotice(notice);
        return ResultVOUtil.success();
    }
    @DeleteMapping("/delNotice/{id}")
    public ResultVO delNotice(@PathVariable Integer id){
        noticeService.delNotice(id);
        return ResultVOUtil.success();
    }
}
