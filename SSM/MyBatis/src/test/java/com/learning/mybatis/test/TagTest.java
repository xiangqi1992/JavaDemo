package com.learning.mybatis.test;

import com.learning.mybatis.mapper.EmpMapper4Tag;
import com.learning.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态sql测试类
 * if
 * where
 * trim
 * choose when otherwise
 * foreach
 * sql片段
 * ……
 */
public class TagTest {

    @Test
    public void testTagMapper() throws IOException {
        EmpMapper4Tag mapper = getMapper(EmpMapper4Tag.class);

        Emp emp = new Emp();

        emp.setEname("Jack");
        emp.setAge(20);
        emp.setGender("M");
        // 查询
        List<Emp> result = mapper.getEmpListByMoreTJ(emp);
        // List<Emp> result = mapper.getEmpListByMoreTJ2(emp);
        // List<Emp> result = mapper.getEmpListByMoreTJ3(emp);
        // List<Emp> result = mapper.getEmpListByChoose(emp);

        // 批量新增
        List<Emp> emps = new ArrayList<>();
        // emp.setEid(123);
        emps.add(emp);
        // int result = mapper.insertMoreEmp(emps);

        // 批量删除
        int[] eids = {123, 456};
        // int result = mapper.deleteMoreByArray1(eids);
        // int result = mapper.deleteMoreByArray2(eids);

        System.out.println("结果：" + result);
    }


    /**
     * 创建EmpMapper接口
     * 通过代理模式创建EmpMapper接口的代理实现类对象
     */
    private <T> T getMapper(Class<T> t) throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        return sqlSession.getMapper(t);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
    }
}
