package com.gitee.alona.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testPage() {
        System.out.println(("----- selectAll method test ------"));
        User user = new User();
        user.setName("hello");
        QueryWrapper<User> qw = new QueryWrapper<>(user);
        IPage<User> userPage = userService.page(new Page<>(1, 5), qw);

        List<User> records = userPage.getRecords();
        Assert.assertEquals(5, records.size());
        records.forEach(System.out::println);
    }

}