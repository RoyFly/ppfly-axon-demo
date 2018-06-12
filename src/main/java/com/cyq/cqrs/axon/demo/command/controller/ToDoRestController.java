package com.cyq.cqrs.axon.demo.command.controller;

import com.cyq.cqrs.axon.demo.command.commands.CloseToDoItemCommand;
import com.cyq.cqrs.axon.demo.command.commands.CreateToDoItemCommand;
import com.cyq.cqrs.axon.demo.command.commands.ResolveToDoItemCommand;
import com.cyq.cqrs.axon.demo.command.reqParam.ToDoItemReqParam;
import com.cyq.cqrs.axon.demo.command.vo.ToDoItemVO;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * @author administrator
 * @create 2018-05-17 14:56
 * @Company: iufc
 * @description：
 **/
@RequestMapping("todo")
@RestController
@Slf4j
public class ToDoRestController {

    @Autowired
    private CommandGateway commandGateway;

    /**
     * 新建一个待办项
     *
     * @param toDoItemReqParam
     */
    @RequestMapping("/create")
    public void create(ToDoItemReqParam toDoItemReqParam) {
        final String todoId = UUID.randomUUID().toString();
        ToDoItemVO toDoItemVO = new ToDoItemVO();
        Instant instant = Instant.now();
        Date createTime = Date.from(instant);
        toDoItemVO.setCreateTime(createTime);
        BeanUtils.copyProperties(toDoItemReqParam, toDoItemVO);
        CreateToDoItemCommand command = new CreateToDoItemCommand(todoId, toDoItemVO);
        commandGateway.send(command);
        log.info("新建待办项结束.......");
    }

    /**
     * 处理待办项
     *
     * @param toDoItemReqParam
     */
    @RequestMapping("/process")
    public void process(@RequestBody ToDoItemReqParam toDoItemReqParam) {
        final String todoId = toDoItemReqParam.getTodoId();
        ToDoItemVO toDoItemVO = new ToDoItemVO();
        BeanUtils.copyProperties(toDoItemReqParam, toDoItemVO);
        ResolveToDoItemCommand command = new ResolveToDoItemCommand(todoId, toDoItemVO);
        commandGateway.send(command);
        log.info("处理待办项结束.......");
    }

    /**
     * 关闭待办项
     *
     * @param todoId
     */
    @RequestMapping("/close")
    public void close(@RequestParam("todoId") String todoId) {
        CloseToDoItemCommand closeToDoItemCommand = new CloseToDoItemCommand(todoId);
        commandGateway.sendAndWait(closeToDoItemCommand);
        log.info("关闭待办项结束.....");
    }
}
