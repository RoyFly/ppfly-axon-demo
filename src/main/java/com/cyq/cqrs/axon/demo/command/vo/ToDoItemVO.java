package com.cyq.cqrs.axon.demo.command.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ToDoItemVO {
    //优先级
    private Integer priority;
    //待办项描述
    private String description;
    //创建时间
    private Date createTime;
}
