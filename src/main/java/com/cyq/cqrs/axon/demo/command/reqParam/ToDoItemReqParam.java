package com.cyq.cqrs.axon.demo.command.reqParam;

import lombok.Data;

@Data
public class ToDoItemReqParam {
    //待办项Id
    private String todoId;
    //优先级
    private Integer priority;
    //待办项描述
    private String description;
}
