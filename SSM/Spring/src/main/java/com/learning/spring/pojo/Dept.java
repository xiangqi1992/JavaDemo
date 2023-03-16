package com.learning.spring.pojo;

import java.util.List;
import java.util.Map;

// 部门类
public class Dept {
    private String dname;

    private List<Emp> empList;

    private Map<String,Emp> empMap;

    public void info(){
        System.out.println("部门名称：" + dname);
        for (Emp emp : empList){
            System.out.println(emp.getEname());
        }
        System.out.println(empMap);
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Map<String, Emp> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<String, Emp> empMap) {
        this.empMap = empMap;
    }
}
