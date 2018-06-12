package com.cyq.cqrs.axon.demo.command.commands;

import com.cyq.cqrs.axon.demo.command.vo.ToDoItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author administrator
 * @create 2018-05-17 10:36
 * @Company: iufc
 * @description：
 **/
@Data
@AllArgsConstructor
public class CreateToDoItemCommand {
    @TargetAggregateIdentifier
    private final String todoId;
    private ToDoItemVO toDoItemVO;
}
