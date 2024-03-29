package com.learning.mybatis.pojo;

/**
 * 员工实体类
 *
 * @author xxx
 * @version 1.0
 * @since 2022-02-22
 */
public class Emp {
    /**
     * 员工id
     */
    private int eid;

    /**
     * 员工姓名
     */
    private String ename;

    /**
     * 员工年龄
     */
    private int age;

    /**
     * 员工性别
     */
    private String gender;

    /**
     * 所属部门
     */
    private Dept dept;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
