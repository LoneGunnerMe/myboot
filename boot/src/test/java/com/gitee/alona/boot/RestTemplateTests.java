package com.gitee.alona.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestTemplateTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://{0}:{1}/", String.class, "172.16.200.48", 1985);
        System.out.println(forEntity);
    }

}
