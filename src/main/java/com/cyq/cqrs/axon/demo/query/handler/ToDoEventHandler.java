package com.cyq.cqrs.axon.demo.query.handler;

import com.cyq.cqrs.axon.demo.command.events.ToDoItemCloseEvent;
import com.cyq.cqrs.axon.demo.command.events.ToDoItemCreatedEvent;
import com.cyq.cqrs.axon.demo.command.events.ToDoItemResolveEvent;
import com.cyq.cqrs.axon.demo.common.Entity.ToDoItemPO;
import com.cyq.cqrs.axon.demo.common.utils.BaseAxonCopyUtil;
import com.cyq.cqrs.axon.demo.query.service.TodoItemService;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author administrator
 * @create 2018-05-17 10:41
 * @Company: iufc
 * @description：
 **/
@Slf4j
@Component
public class ToDoEventHandler {
    @Autowired
    private TodoItemService todoItemService;

    /**
     * handle 创建待办项event
     *
     * @param event
     */
    @EventHandler
    public void handle(ToDoItemCreatedEvent event) {
        ToDoItemPO toDoItemPO = new ToDoItemPO();
        BeanUtils.copyProperties(event.getToDoItemVO(), toDoItemPO);
        toDoItemPO.setTodoId(event.getTodoId());
        todoItemService.saveOrUpdate(toDoItemPO);
        log.info("您有新的待办事项 “" + toDoItemPO.getDescription() + " ”请及时处理(" + event.getTodoId() + ")");
    }

    /**
     * handle 处理待办项event
     *
     * @param event
     */
    @EventHandler
    public void handle(ToDoItemResolveEvent event) {
        ToDoItemPO toDoItemPO = todoItemService.findOne(event.getTodoId());
        BeanUtils.copyProperties(event.getToDoItemVO(), toDoItemPO, BaseAxonCopyUtil.getNullPropertyNames(event.getToDoItemVO()));
        toDoItemPO.setTodoId(event.getTodoId());
        todoItemService.saveOrUpdate(toDoItemPO);
        log.info("待办事项已处理(" + event.getTodoId() + ")");
    }

    /**
     * handle 关闭待办项event
     *
     * @param event
     */
    @EventHandler
    public void handle(ToDoItemCloseEvent event) {
        log.info("待办事项已关闭(" + event.getTodoId() + ")");
    }
}
