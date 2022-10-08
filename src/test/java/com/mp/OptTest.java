package com.mp;

import com.mp.dao.UserMapper;
import com.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateById(){
        int version = 1;

        User user = new User();
        user.setAge(29);
        user.setId(1578592620243845121L);
        user.setEmail("ly@baomidou.com");
        user.setVersion(version);
        int rows = userMapper.updateById(user);
        System.out.println("影响行数："+rows);
    }
}
