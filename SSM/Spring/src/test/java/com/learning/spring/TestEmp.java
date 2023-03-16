package com.learning.spring;

import com.learning.spring.pojo.Dept;
import com.learning.spring.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {

    private Logger logger = LoggerFactory.getLogger(TestEmp.class);

    @Test
    public void testEmp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Emp emp = (Emp) context.getBean("emp");
        emp.work();
    }

    @Test
    public void testDept() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Dept dept = (Dept) context.getBean("dept5");
        dept.info();
    }
}
