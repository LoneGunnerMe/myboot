package com.gitee.alona.boot.cache;

import cn.hutool.core.util.RandomUtil;
import com.gitee.alona.boot.common.cache.MyRedisCacheConfiguration;
import com.gitee.alona.boot.test.SpringCacheTestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringCacheTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCacheTest.class);

    @Autowired
    private SpringCacheTestService springCacheTestService;

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void before() {
        Assert.assertNotNull(applicationContext.getBean(RedisConnectionFactory.class));
        Assert.assertNotNull(applicationContext.getBean(MyRedisCacheConfiguration.class));
    }

    @Test
    public void list() {
        LOGGER.info("list Running........");
        for (int i = 0; i < 5; i++) {
            List<String> list = springCacheTestService.list();
            Assert.assertNotNull(list);
            Assert.assertEquals(list.size(), 3L);
            LOGGER.info("list: {}", String.join("", list));
        }
    }

    @Test
    public void string() {
        LOGGER.info("string Running........");
        for (int i = 0; i < 5; i++) {
//            List<String> list = springCacheTestService.string(RandomUtil.randomString(i));
            List<String> list = springCacheTestService.string(String.valueOf(Math.pow(10, i)));
//            List<String> list = springCacheTestService.string("111");
            Assert.assertNotNull(list);
            Assert.assertEquals(list.size(), 4L);
            LOGGER.info("list: {}", String.join("", list));
        }
    }

    @Test
    public void nonExpiredKey() {
        LOGGER.info("string Running........");
        for (int i = 0; i < 5; i++) {
            List<String> list = springCacheTestService.nonExpiredKey(String.valueOf(Math.pow(10, i)));
            Assert.assertNotNull(list);
            Assert.assertEquals(list.size(), 4L);
            LOGGER.info("list: {}", String.join("", list));
        }
    }
}
