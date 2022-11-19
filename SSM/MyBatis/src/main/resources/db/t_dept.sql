drop table if exists T_DEPT;

/*==============================================================*/
/* Table: T_DEPT 部门信息表                                       */
/*==============================================================*/
create table T_DEPT
(
    D_ID      int(20) not null comment '主键 部门ID',
    D_NAME   varchar(20) comment '部门名称',
    primary key (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_DEPT comment '部门信息表';