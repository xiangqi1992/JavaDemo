package com.learning.spring;

import com.learning.spring.pojo.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    private Logger logger = LoggerFactory.getLogger(TestReflect.class);

    /**
     * 1、获取class对象多种方式
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test01() throws Exception {
        // 1、类名.class
        Class clazz1 = User.class;
        // 2、对象.getClass()
        Class clazz2 = new User().getClass();
        // 3、Class.forName("全路径")
        Class clazz3 = Class.forName("com.learning.spring.pojo.User");

        // 实例化
        User user = (User) clazz3.getDeclaredConstructor().newInstance();

        System.out.println(user);
    }

    /**
     * 2、获取构造方法
     */
    @Test
    public void test02() throws Exception {
        Class clazz = User.class;
        // 1、获取所有的构造方法
        // clazz.getConstructors() public 构造方法
        // clazz.getDeclaredConstructors() public private 构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("方法名称：" + constructor.getName() + ", 参数个数：" + constructor.getParameterCount());
        }

        // 2、指定有参数构造创建对象
        // 2.1 构造public
        Constructor c1 = clazz.getConstructor(String.class, Integer.class, char.class);
        User user1 = (User) c1.newInstance("张三", 18, 'M');
        System.out.println(user1);
        // 2.2 构造private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, Integer.class, String.class);
        c2.setAccessible(true);
        User user2 = (User) c2.newInstance("李四", 18, "hahaha");
        System.out.println(user2);
    }

    /**
     * 3、获取属性
     */
    @Test
    public void test03() throws Exception {
        Class clazz = User.class;
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        // 获取所有public属性
        // Field[] fields = clazz.getFields();
        // 获取所以属性（包含私有属性）
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(user, "王五");
            }
            System.out.println("属性名称：" + field.getName());
        }
        System.out.println(user);
    }

    /**
     * 4、获取方法
     */
    @Test
    public void test04() throws Exception {
        User user = new User("王五", 18, 'M');
        Class clazz = user.getClass();
        // 1、public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            // System.out.println("方法名称：" + method.getName());
            if (method.getName().equals("toString")) {
                String invoke = (String) method.invoke(user);
                System.out.println("toString方法执行了：" + invoke);
            }
        }
        // 2、private方法
        Method[] methodsAll = clazz.getDeclaredMethods();
        for (Method method : methodsAll) {
            if (method.getName().equals("cut")) {
                method.setAccessible(true);
                method.invoke(user);
            }

        }
    }

}
