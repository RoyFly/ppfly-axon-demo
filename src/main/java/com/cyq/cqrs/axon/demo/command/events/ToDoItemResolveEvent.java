package com.cyq.cqrs.axon.demo.command.events;

import com.cyq.cqrs.axon.demo.command.vo.ToDoItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoItemResolveEvent {
    private final String todoId;
    private ToDoItemVO toDoItemVO;
}
