package com.cyq.cqrs.axon.demo.command.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author administrator
 * @create 2018-05-17 10:37
 * @Company: iufc
 * @description：
 **/
@Data
@AllArgsConstructor
public class CloseToDoItemCommand {
    @TargetAggregateIdentifier
    private final String todoId;
}
