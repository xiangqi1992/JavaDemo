package com.learning.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.learning.mybatis.PageVO;
import com.learning.mybatis.mapper.UserMapper1;
import com.learning.mybatis.mapper.UserMapper2;
import com.learning.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

     /**
      * SqlSession：代表Java程序和数据库之间的会话。（HttpSession是Java程序和浏览器之间的会话）
      * SqlSessionFactory：是“生产”SqlSession的“工厂”。
      *
      * 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，
      * 以后都使用这个工厂类来“生产”我们需要的对象。
      */
    @Test
    public void testUser() throws IOException {
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
        UserMapper1 userMapper1 = sqlSession.getMapper(UserMapper1.class);

        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper1.insertUser();
        // int result = userMapper.updateUser();
        // User result = userMapper.getUserById();
        // List<User> result = userMapper.getUserList();
        // int result = userMapper.deleteUser();
        //sqlSession.commit();

        System.out.println("结果："+result);
    }

    @Test
    public void pageQueryByPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
        int pageNum = 1;
        int pageSize = 10;
        // 这一行代码之后需要立即接上需要分页的查询方法，否则可能导致分页失效
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<User> userList = mapper.getUserList();
        System.out.println(new PageVO<>(pageSize, pageNum, (int) page.getTotal(), userList));
    }
}
