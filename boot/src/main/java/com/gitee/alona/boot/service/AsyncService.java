package com.gitee.alona.boot.service;

import com.gitee.alona.boot.manager.api.MyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 16:12
 */
@Service
public class AsyncService {
    private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    private MyClient client;

    @Async
    public void asyncMethod() {
        log.info("async ok");
        String s = client.simpleRequest();
        log.info("async simpleRequest:{}", s);
        new Thread(() -> {
            log.info("hello");
        }).start();
    }
}
