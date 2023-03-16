package com.learning.spring.pojo;

import java.util.Arrays;

// 员工类
public class Emp {
    private String ename;
    private Integer age;
    // 爱好
    private  String[] loves;

    // 员工所属部门
    private Dept dept;

    public void work(){
        System.out.println(ename + "Emp work……" + age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                '}';
    }
}
