package com.learning.mybatis.test;

import com.learning.mybatis.mapper.DeptMapper;
import com.learning.mybatis.mapper.EmpMapper;
import com.learning.mybatis.pojo.Dept;
import com.learning.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 部门信息测试类
 */
public class DeptTest {

    /**
     * Mapper 一对多映射处理
     */
    @Test
    public void testOne2MoreMapper() throws IOException {
        DeptMapper mapper = getMapper(DeptMapper.class);

        // a> 使用association处理映射关系
        Dept result = mapper.getDeptEmpByDid(1);

        // b> 分步查询
        // Dept result = mapper.getDeptByStep(1);
        // EmpMapper empMapper = getMapper(EmpMapper.class);
        // List<Emp> emps = empMapper.getEmpListByDid(result.getDid());
        // result.setEmps(emps);

        System.out.println("结果：" + result);
    }

    /**
     * 创建DeptMapper接口
     * 通过代理模式创建DeptMapper接口的代理实现类对象
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
