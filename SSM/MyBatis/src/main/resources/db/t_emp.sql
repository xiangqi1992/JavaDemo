drop table if exists T_EMP;

/*==============================================================*/
/* Table: T_EMP 员工信息表                                        */
/*==============================================================*/
create table T_EMP
(
    E_ID    int(20) not null comment '主键 员工ID',
    E_NAME varchar(20) comment '员工姓名',
    AGE    tinyint(3) comment '年龄',
    GENDER    varchar(1) comment '性别',
    DID    varchar(32) comment '电子邮件',
    primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_EMP comment '员工信息表';