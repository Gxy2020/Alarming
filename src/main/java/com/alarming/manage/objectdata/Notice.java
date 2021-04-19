package com.alarming.manage.objectdata;

import lombok.Data;

import javax.persistence.*;

/**
 * @author GUO
 * @Classname Notice
 * @Description 公告
 * @Date 2021/4/20 4:47
 */
@Data
@Entity
@Table(name = "t_notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "state")
    private Integer state;
    @Column(name = "create_time")
    private String createTime;

}
