package com.cyq.cqrs.axon.demo.command.events;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author administrator
 * @create 2018-05-17 10:40
 * @Company: iufc
 * @description：
 **/
@Data
@AllArgsConstructor
public class ToDoItemCloseEvent {
    private final String todoId;
}