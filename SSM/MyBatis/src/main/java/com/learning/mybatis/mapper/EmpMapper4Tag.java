package com.learning.mybatis.mapper;

import com.learning.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper4Tag {
    List<Emp> getEmpListByMoreTJ(Emp emp);

    List<Emp> getEmpListByMoreTJ2(Emp emp);

    List<Emp> getEmpListByMoreTJ3(Emp emp);

    List<Emp> getEmpListByChoose(Emp emp);

    int insertMoreEmp(List<Emp> emps);

    int deleteMoreByArray1(int[] eids);

    int deleteMoreByArray2(int[] eids);
}
