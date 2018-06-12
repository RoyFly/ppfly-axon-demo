package com.cyq.cqrs.axon.demo.command.commands;

import com.cyq.cqrs.axon.demo.command.vo.ToDoItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class ResolveToDoItemCommand {
    @TargetAggregateIdentifier
    private final String todoId;
    private ToDoItemVO toDoItemVO;
}
