package com.learning.mybatisplus;

import com.learning.mybatisplus.mapper.UserMapper;
import com.learning.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User(null, "张三", "123", 23, "M", "zhangsan@atguigu.com", "N");
        //INSERT INTO t_user ( id, userName, password, age, gender, email ) VALUES ( ?, ?, ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("受影响行数：" + result);
        //1475754982694199298
        System.out.println("id自动获取：" + user.getId());
    }


    @Test
    public void testDeleteById() {
        //通过id删除用户信息
        //DELETE FROM t_user WHERE id=?
        int result = userMapper.deleteById(1475754982694199298L);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void testDeleteBatchIds() {
        //通过多个id批量删除
        //DELETE FROM t_user WHERE id IN ( ? , ? , ? )
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void testDeleteByMap() {
        //根据map集合中所设置的条件删除记录
        //DELETE FROM t_user WHERE user_name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 23);
        map.put("user_name", "张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void testUpdateById() {
        User user = new User(4L, "admin", null, 22, null, null, "N");
        //UPDATE t_user SET user_name=?, age=? WHERE id=?
        int result = userMapper.updateById(user);
        System.out.println("受影响行数：" + result);
    }

    @Test
    public void testSelectById() {
        //根据id查询用户信息
        //SELECT id,user_name,password,age,gender,email FROM t_user WHERE id=?
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        //根据多个id查询多个用户信息
        //SELECT id,user_name,password,age,gender,email FROM t_user WHERE id IN ( ? , ? )
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap() {
        //通过map条件查询用户信息
        //SELECT id,user_name,password,age,gender,email FROM t_user WHERE user_name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 22);
        // 不能使用userName
        map.put("user_name", "admin");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectList() {
        //查询所有用户信息
        // SELECT id,user_name,password,age,gender,email FROM t_user
        // selectList() 根据MybaitsPlus内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
