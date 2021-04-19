package com.alarming.manage.controller;

import com.alarming.manage.objectdata.Message;
import com.alarming.manage.service.MajorService;
import com.alarming.manage.service.MessageService;
import com.alarming.manage.utils.ResultVOUtil;
import com.alarming.manage.vo.ResultVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GUO
 * @Classname MessageController
 * @Description TODO
 * @Date 2021/4/19 17:56
 */
@Slf4j
@Api(tags = "预警内容接口")
@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping("/sendMessage")
    public ResultVO sendMessage(Message messages){
        boolean b = messageService.sendMessage(messages);
        return b? ResultVOUtil.success():ResultVOUtil.error(500,"发送失败");
    }
    @GetMapping("/findBySendId/{sendId}")
    public ResultVO findBySendId(@PathVariable String sendId){
        List<Message> messageList = messageService.findBySendId(sendId);
        return ResultVOUtil.success(messageList);
    }
    @GetMapping("/findByReceiverId/{receiverId}")
    public ResultVO findByReceiverId(@PathVariable String receiverId){
        List<Message> messageList = messageService.findByReceiverId(receiverId);
        return ResultVOUtil.success(messageList);
    }
}
