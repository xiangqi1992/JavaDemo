drop table if exists T_USER;

/*==============================================================*/
/* Table: T_USER  用户信息表                                      */
/*==============================================================*/
create table T_USER
(
    ID        bigint(20) not null comment '主键 用户ID',
    USER_NAME varchar(30) comment '用户名',
    PASSWORD  varchar(20) comment '密码',
    AGE       tinyint(3) comment '年龄',
    GENDER    varchar(1) comment '性别',
    EMAIL     varchar(50) comment '电子邮件',
    primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_USER comment '用户信息表';

-- 初始化数据
INSERT INTO user (ID, USER_NAME, PASSWORD, AGE, GENDER, EMAIL)
VALUES (1, 'Jone', '123', 18, 'M', 'test1@163.com'),
       (2, 'Jack', '123', 20, 'M', 'test2@163.com'),
       (3, 'Tom', '123', 28, 'M', 'test3@163.com'),
       (4, 'Sandy', '123', 21, 'W', 'test4@163.com'),
       (5, 'Billie', '123', 24, 'W', 'test5@163.com');