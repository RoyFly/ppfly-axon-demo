package com.cyq.cqrs.axon.demo.common.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_TODO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItemPO {

    @Id
    //    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    private String todoId;
    @Column(columnDefinition = "char(1) comment'优先级'")
    private Integer priority;
    @Column(columnDefinition = "text comment'待办项描述'")
    private String description;
    @Column(columnDefinition = "datetime comment'创建时间'")
    private Date createTime;
}
