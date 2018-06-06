package me.jollyfly.blog.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "t_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, columnDefinition = "varchar(20) COMMENT '用户名'")
    private String nic;

    @Column(columnDefinition = "varchar(10) comment '姓名'")
    private String name;

    @Column(columnDefinition = "varchar(80) comment '邮箱'")
    private String email;

    @Column(columnDefinition = "varchar(20) comment '地方'")
    private String location;

    @Column(columnDefinition = "varchar(40) comment '密码'", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(100) comment '头像'")
    private String avatar;

    @Column(columnDefinition = "varchar(40) comment '个性签名'")
    private String signature;

    @Column(nullable = false, columnDefinition = "datetime default now() comment '上次登录时间'")
    private Timestamp lastLogin;

    @Column(nullable = false, columnDefinition = "datetime default now() comment '创建时间'")
    private Timestamp createTime;

    @Column(nullable = false, columnDefinition = "datetime default now() comment '修改时间'")
    private Timestamp modifyTime;
}
