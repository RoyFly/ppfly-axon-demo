package com.cyq.cqrs.axon.demo.query.service;

import com.cyq.cqrs.axon.demo.common.Entity.ToDoItemPO;
import com.cyq.cqrs.axon.demo.query.repository.TodoItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public ToDoItemPO findOne(String id) {
        ToDoItemPO toDoItemPO = todoItemRepository.findById(id).get();
        return toDoItemPO;
    }

    @Override
    public void saveOrUpdate(ToDoItemPO toDoItemPO) {
        todoItemRepository.save(toDoItemPO);
    }
}
