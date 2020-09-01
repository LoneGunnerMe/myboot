package com.gitee.alona.boot.service.impl;

import com.gitee.alona.boot.dao.UserDao;
import com.gitee.alona.boot.entity.User;
import com.gitee.alona.boot.mapper.UserMapper;
import com.gitee.alona.boot.service.UserService;
import com.gitee.alona.boot.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 17:30
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<UserDTO, User, UserMapper, UserDao> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @Cacheable(cacheNames = "user:list")
    public List<User> list() {
        LOGGER.info("查询...");
        return IntStream.range(0, 10)
                .boxed()
                .map(i -> {
                    User user = new User();
                    user.setName(String.valueOf(i));
                    user.setAge(i);
                    return user;
                })
                .collect(Collectors.toList());
    }
}
