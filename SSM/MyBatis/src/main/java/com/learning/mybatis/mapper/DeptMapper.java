package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 根据部门id查新部门以及部门中的员工信息
     * @param did
     * @return
     */
    Dept getDeptEmpByDid(@Param("did") int did);

    /**
     * 分步查询的第一步：分步查询部门和部门中的员工
     * @param did
     * @return
     */
    Dept getDeptByStep(@Param("did") int did);

    /**
     * 分步查询的第二步：根据员工所对应的did查询部门信息
     * @param did
     * @return
     */
    Dept getEmpDeptByStep(@Param("did") int did);
}
