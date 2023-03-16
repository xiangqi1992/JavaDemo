package com.learning.spring.pojo;

public class User {
    private String name;
    private Integer age;
    private char gender;
    private String info;

    public User(String name, Integer age, char gender) {
        System.out.println("1、bean对象创建，调用有参构造… ");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private User(String name, Integer age, String info) {
        this.name = name;
        this.age = age;
        this.info = info;
    }

    public User() {
        System.out.println("1、bean对象创建，调用无参构造… ");
    }

    // 初始化的方法
    public void initMethod() {
        System.out.println("4、bean对象初始化，调用指定的初始化方法… ");
    }
    // 销毁的方法
    public void destroyMethod() {
        System.out.println("7、bean对象销毁，调用指定的销毁方法… ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2、给bean对象设置属性值… ");
        System.out.println("2.1、setName执行了… ");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("2.2、setAge执行了… ");
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        System.out.println("2.3、setGender执行了… ");
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        System.out.println("2.4、setInfo执行了… ");
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

    public void add() {
        System.out.println("add....");
    }

    private void cut() {
        System.out.println("cut....");
    }

    public static void main(String[] args) {
        User user = new User();
        user.add();
    }
}
