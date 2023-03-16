package com.learning.spring.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component(value = "userAnnotation")
//@Repository dao层
//@Service service层
//@Controller controller层
public class UserAnnotation {
    private String name;
    private Integer age;
    private char gender;
    private String info;

    public UserAnnotation(String name, Integer age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public UserAnnotation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", info='" + info + '\'' +
                '}';
    }
}
