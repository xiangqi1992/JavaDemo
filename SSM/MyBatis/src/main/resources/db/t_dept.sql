drop table if exists T_DEPT;

/*==============================================================*/
/* Table: T_DEPT 部门信息表                                       */
/*==============================================================*/
create table T_DEPT
(
    D_ID      int(20) not null comment '主键 部门ID',
    D_NAME   varchar(20) comment '部门名称',
    primary key (D_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_DEPT comment '部门信息表';

-- 初始化数据
INSERT INTO T_DEPT (D_ID, D_NAME)
VALUES (1, 'IT部'),
       (2, '运营部'),
       (3, '执行部');