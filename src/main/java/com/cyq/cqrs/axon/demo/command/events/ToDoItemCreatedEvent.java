package com.cyq.cqrs.axon.demo.command.events;

import com.cyq.cqrs.axon.demo.command.vo.ToDoItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author administrator
 * @create 2018-05-17 10:39
 * @Company: iufc
 * @description：
 **/
@Data
@AllArgsConstructor
public class ToDoItemCreatedEvent {
    private final String todoId;
    private ToDoItemVO toDoItemVO;
}
