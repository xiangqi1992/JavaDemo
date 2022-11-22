package com.learning.mybatis.pojo;

import java.util.List;

/**
 * 部门实体类
 *
 * @author xxx
 * @version 1.0
 * @since 2022-02-22
 */
public class Dept {
    /**
     * 部门id
     */
    private int did;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 部门员工
     */
    private List<Emp> emps;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                ", emps=" + emps +
                '}';
    }
}
