package com.gitee.alona.boot.manager.api;

import cn.hutool.json.JSONUtil;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@ForestScan(basePackages = "com.gitee.alona.boot.manager.api")
@RunWith(SpringRunner.class)
class MyClientTest {

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
}