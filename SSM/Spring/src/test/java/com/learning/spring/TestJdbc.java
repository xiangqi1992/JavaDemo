package com.learning.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {

    private Logger logger = LoggerFactory.getLogger(TestJdbc.class);

    @Test
    public void testJdbc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        DruidDataSource druid = context.getBean(DruidDataSource.class);

        System.out.println(druid.getUrl());
    }
}
