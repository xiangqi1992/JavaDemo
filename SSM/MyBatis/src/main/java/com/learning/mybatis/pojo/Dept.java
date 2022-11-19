package com.learning.mybatis.pojo;

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
    private String did;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 办公地
     */
    private String loc;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
