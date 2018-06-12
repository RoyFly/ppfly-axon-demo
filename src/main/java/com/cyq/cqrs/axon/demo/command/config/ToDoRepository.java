package com.cyq.cqrs.axon.demo.command.config;

import com.cyq.cqrs.axon.demo.command.aggregate.ToDoItemAggregate;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author administrator
 * @create 2018-05-17 11:22
 * @Company: iufc
 * @description：
 **/
@Configuration
public class ToDoRepository {

    @Bean
    public Repository<ToDoItemAggregate> initToDoRepository(EventStore eventStore) {
        return new EventSourcingRepository<>(ToDoItemAggregate.class, eventStore);
    }
}
