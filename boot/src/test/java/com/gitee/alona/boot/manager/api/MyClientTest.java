package com.gitee.alona.boot.manager.api;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.gitee.alona.boot.web.rest.TestController;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
@ForestScan(basePackages = "com.gitee.alona.boot.manager.api")
@RunWith(SpringRunner.class)
class MyClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyClientTest.class);

    @Autowired
    private MyClient myClient;

    @Test
    void simpleRequest() {
        String s = myClient.simpleRequest();
        System.out.println(s);
        System.out.println("-------------------");
    }

    @Test
    void getLocation() {
        Map result = myClient.getLocation("124.730329", "31.463683");
        System.out.println(JSONUtil.toJsonStr(result));
        System.out.println("-------------------");
    }

    @Test
    void requestDate() {
        TestController.RequestDateDTO requestDateDTO = new TestController.RequestDateDTO();
        requestDateDTO.setDate(new Date());
        requestDateDTO.setLocalDateTime(LocalDateTime.now());
        requestDateDTO.setName(UUID.randomUUID().toString());
        LOGGER.info(JSON.toJSONString(requestDateDTO));
        Map<String, Object> result = myClient.jsonDate(requestDateDTO);
        LOGGER.info(JSON.toJSONString(result));
        LOGGER.info("-------------------");
    }
}