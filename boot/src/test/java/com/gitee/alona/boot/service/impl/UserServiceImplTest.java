package com.gitee.alona.boot.service.impl;

import com.gitee.alona.boot.service.UserService;
import com.gitee.alona.boot.service.dto.UserDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void createTest() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(20);
        userDTO.setEmail("aaa@163.com");
        userDTO.setName("王五");
        UserDTO userDTO1 = userService.create(userDTO);
        Assert.assertNotNull(userDTO1.getId());
        System.out.println(userDTO1);
    }
}