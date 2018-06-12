package com.cyq.cqrs.axon.demo.command.aggregate;

import com.cyq.cqrs.axon.demo.command.commands.CreateToDoItemCommand;
import com.cyq.cqrs.axon.demo.command.commands.CloseToDoItemCommand;
import com.cyq.cqrs.axon.demo.command.commands.ResolveToDoItemCommand;
import com.cyq.cqrs.axon.demo.command.events.ToDoItemCloseEvent;
import com.cyq.cqrs.axon.demo.command.events.ToDoItemCreatedEvent;
import com.cyq.cqrs.axon.demo.command.events.ToDoItemResolveEvent;
import com.cyq.cqrs.axon.demo.command.vo.ToDoItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * @author administrator
 * @create 2018-05-17 10:54
 * @Company: iufc
 * @description：
 **/
@Aggregate
@Slf4j
@Data
@AllArgsConstructor
public class ToDoItemAggregate {
    @AggregateIdentifier
    private String id;
    private String state;
    private ToDoItemVO toDoItemVO;

    public ToDoItemAggregate() {
        log.info("ToDoItem无参构造函数");
    }

    @CommandHandler
    public ToDoItemAggregate(CreateToDoItemCommand command) {
        ToDoItemCreatedEvent event = new ToDoItemCreatedEvent(command.getTodoId(), command.getToDoItemVO());
        log.info("CommandHandler CreateToDoItemCommand before1111111");
        apply(event);
        log.info("CommandHandler CreateToDoItemCommand after22222222");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("CommandHandler CreateToDoItemCommand 333333");
    }

    /**
     * handle 创建待办事项event
     *
     * @param event
     */
    @EventHandler
    public void on(ToDoItemCreatedEvent event) {
        this.id = event.getTodoId();
        this.state = "已创建";
        this.toDoItemVO = event.getToDoItemVO();
        log.info("待办已创建......");
    }

    @CommandHandler
    public void on(ResolveToDoItemCommand command) {
        ToDoItemResolveEvent event = new ToDoItemResolveEvent(command.getTodoId(), command.getToDoItemVO());
        log.info("CommandHandler ResolveToDoItemCommand before111111");
        apply(event);
        log.info("CommandHandler ResolveToDoItemCommand after222222");
    }

    /**
     * handle 处理待办事项event
     *
     * @param event
     */
    @EventHandler
    public void on(ToDoItemResolveEvent event) {
        this.state = "已处理";
        this.toDoItemVO = event.getToDoItemVO();
        log.info("待办已处理......");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @CommandHandler
    public void on(CloseToDoItemCommand command) {
        ToDoItemCloseEvent event = new ToDoItemCloseEvent(id);
        log.info("CommandHandler CloseToDoItemCommand before111111");
        apply(event);
        log.info("CommandHandler CloseToDoItemCommand after222222");
    }

    /**
     * handle 关闭待办事项event
     *
     * @param event
     */
    @EventHandler
    public void on(ToDoItemCloseEvent event) {
        this.state = "已关闭";
        log.info("待办已关闭......");
    }

}
