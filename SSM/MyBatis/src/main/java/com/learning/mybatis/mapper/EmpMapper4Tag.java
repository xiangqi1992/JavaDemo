package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper4Tag {
    List<Emp> getEmpListByMoreTJ(Emp emp);

    List<Emp> getEmpListByMoreTJ2(Emp emp);

    List<Emp> getEmpListByMoreTJ3(Emp emp);

    List<Emp> getEmpListByChoose(Emp emp);

    int insertMoreEmp(@Param("emps")List<Emp> emps);

    int deleteMoreByArray1(@Param("eids")int[] eids);

    int deleteMoreByArray2(@Param("eids")int[] eids);
}
