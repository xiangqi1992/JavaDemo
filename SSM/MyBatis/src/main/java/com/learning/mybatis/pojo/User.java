package com.learning.mybatis.pojo;

/**
 * 用户实体类
 *
 * @author xxx
 * @version 1.0
 * @since 2022-02-22
 */
public class User {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 删除标识
     */
    private String deleted;

    public User() {
    }

    public User(Long id, String userName, String password, Integer age, String gender, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
