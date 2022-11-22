drop table if exists T_EMP;

/*==============================================================*/
/* Table: T_EMP 员工信息表                                        */
/*==============================================================*/
create table T_EMP
(
    E_ID   int(20) not null comment '主键 员工ID',
    E_NAME varchar(20) comment '员工姓名',
    AGE    tinyint(3) comment '年龄',
    GENDER varchar(1) comment '性别',
    D_ID    varchar(32) comment '所属部门ID',
    primary key (E_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_EMP comment '员工信息表';

-- 初始化数据
INSERT INTO T_EMP (E_ID, E_NAME, AGE, GENDER, D_ID)
VALUES (1, 'Jone', 18, 'M', 1),
       (2, 'Jack', 20, 'M', 1),
       (3, 'Tom', 28, 'M', 1),
       (4, 'Sandy', 21, 'W', 2),
       (5, 'Billie', 24, 'W', 3);