package com.cyq.cqrs.axon.demo.query.repository;

import com.cyq.cqrs.axon.demo.common.Entity.ToDoItemPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<ToDoItemPO, String>,JpaSpecificationExecutor {
}
