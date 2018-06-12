package com.cyq.cqrs.axon.demo.command.reqParam;

import lombok.Data;

@Data
public class ToDoItemCloseReqParam {
    //待办事项Id
    private String todoId;
}
