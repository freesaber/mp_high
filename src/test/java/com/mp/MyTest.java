package com.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mp.dao.UserMapper;
import com.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById(){
        int rows = userMapper.deleteById(1094592041087729666L);
        System.out.println("影响行数："+rows);
    }

    @Test
    public void select(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void updateById(){
        User user = new User();
        user.setAge(26);
        user.setId(1088248166370832385L);
        int rows = userMapper.updateById(user);
        System.out.println("影响行数："+rows);
    }

    @Test
    public void MySelect(){
        List<User> users = userMapper.mySelectList(Wrappers.<User>lambdaQuery()
                .gt(User::getAge,25)
                .eq(User::getDeleted, 0)
        );
        users.forEach(System.out::println);
    }
}
