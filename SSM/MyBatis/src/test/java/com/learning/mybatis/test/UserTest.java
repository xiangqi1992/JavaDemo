package com.learning.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.learning.mybatis.common.PageVO;
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
import java.util.Map;

/**
 * 用户信息测试类
 *
 * SqlSession：代表Java程序和数据库之间的会话。（HttpSession是Java程序和浏览器之间的会话）
 * SqlSessionFactory：是“生产”SqlSession的“工厂”。
 *
 * 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，
 * 以后都使用这个工厂类来“生产”我们需要的对象。
 */
public class UserTest {

    /**
     * Mapper1 测试 增删改查
     */
    @Test
    public void testUserMapper1() throws IOException {
        UserMapper1 mapper = getMapper(UserMapper1.class);

        int result = mapper.insertUser();
        // int result = mapper.updateUser();
        // User result = mapper.getUserById();
        // List<User> result = mapper.getUserList();
        // int result = mapper.deleteUser();

        System.out.println("结果："+result);
    }

    /**
     * Mapper2 测试 增删改查
     */
    @Test
    public void testUserMapper2_1() throws IOException {
        UserMapper2 mapper = getMapper(UserMapper2.class);

        User user = new User(111L,"xiaoming","123",12,"M","test1@163.com");
        int result = mapper.insertUser(user);
        // user.setUserName("mingming");
        // int result = mapper.updateUser(user);
        // User result = mapper.getUserById(111);
        // List<User> result = mapper.getUserList();
        // int result = mapper.deleteUser(111);

        System.out.println("结果："+result);
    }

    /**
     * Mapper2 测试 MyBatis的各种查询功能、特殊SQL的执行(模糊、批量删除、动态表名)、自定义映射resultMap
     */
    @Test
    public void testUserMapper2_2() throws IOException {
        UserMapper2 mapper = getMapper(UserMapper2.class);;

        int result = mapper.getCount();
        // Map<String, Object> result = mapper.getUserToMap(2);
        // List<Map<String, Object>> result = mapper.getAllUserToMapList();
        // Map<String, Object> result = mapper.getAllUserToMap();
        // List<User> result = mapper.mohuQuery("To");
        // int result = mapper.deleteMore("1,2");
        // List<User> result = mapper.getAllUser("T_USER");
        // List<User> result = mapper.mohuQuery2("To");

        System.out.println("结果："+result);
    }

    /**
     * 分页查询
     */
    @Test
    public void pageQueryByPageHelper() throws IOException {
        UserMapper2 mapper = getMapper(UserMapper2.class);
        int pageNum = 1;
        int pageSize = 10;
        // 这一行代码之后需要立即接上需要分页的查询方法，否则可能导致分页失效
        Page page = PageHelper.startPage(pageNum, pageSize);
        List<User> userList = mapper.getUserList();

        System.out.println(new PageVO<>(pageSize, pageNum, (int) page.getTotal(), userList));
    }

    /**
     * 创建UserMapper接口
     * 通过代理模式创建UserMapper接口的代理实现类对象
     */
    private <T>T getMapper(Class<T> t) throws IOException{
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
