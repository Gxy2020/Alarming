package com.alarming.manage.objectdata;

import lombok.Data;

import javax.persistence.*;

/**
 * @author GUO
 * @Classname Message
 * @Description TODO
 * @Date 2021/4/19 17:42
 */
@Data
@Entity
@Table(name = "t_message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "c_send_id")
    private String sendId;
    @Column(name = "receiver_id")
    private String receiverId;
    @Column(name = "message")
    private String messages;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "source")
    private String source;
}
