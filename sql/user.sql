drop database if exists blog;
create database if not exists blog;
use blog;

create table if not exists t_user(
  id int(11) primary key AUTO_INCREMENT comment '用户id',
  nic varchar(30) unique not null comment '用户名',
  name varchar(10) comment '姓名',
  email varchar(80) comment '邮箱',
  location varchar(10) comment '地方',
  password varchar(40) not null comment '密码',
  avatar varchar(100) comment '头像',
  signature varchar(40) comment '个性签名',
  last_login datetime not null default now() comment '上次登录时间',
  create_time datetime not null default now() comment '创建时间',
  modify_time datetime not null default now() comment '修改时间'

)ENGINE=InnoDB DEFAULT CHARSET=utf8;