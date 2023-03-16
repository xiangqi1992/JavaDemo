package com.learning.mybatisplus;

import com.learning.mybatisplus.pojo.User;
import com.learning.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    @Test
    public void testSaveBatch() {
        // SQL长度有限制，海量数据插入单条SQL无法实行，
        // 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUserName("ybc" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        //SQL:INSERT INTO t_user ( username, age ) VALUES ( ?, ? )
        userService.saveBatch(users);
    }
}
