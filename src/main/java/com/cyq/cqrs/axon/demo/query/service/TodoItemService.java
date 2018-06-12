package com.cyq.cqrs.axon.demo.query.service;

import com.cyq.cqrs.axon.demo.common.Entity.ToDoItemPO;

public interface TodoItemService {

    /**
     * 根据待办Id查找待办项
     *
     * @param id
     * @return
     */
    ToDoItemPO findOne(String id);

    /**
     * 保存/更新代办项
     *
     * @param toDoItemPO
     */
    void saveOrUpdate(ToDoItemPO toDoItemPO);
}
