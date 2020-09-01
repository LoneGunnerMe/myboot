package com.gitee.alona.boot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gitee.alona.boot.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userDao.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    void testQueryList() {
        User user = new User();
        user.setName("hello");
        QueryWrapper<User> qw = new QueryWrapper<>(user);
        List<User> userList = userDao.findList1(qw);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

}