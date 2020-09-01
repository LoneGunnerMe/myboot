package com.gitee.alona.boot.web.rest;

import com.gitee.alona.boot.manager.api.BaiduApi;
import com.gitee.alona.boot.manager.api.MyClient;
import com.gitee.alona.boot.service.AsyncService;
import com.gitee.alona.boot.web.rest.response.ResponseUtil;
import com.gitee.alona.boot.web.rest.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 9:38
 */
@RestController
@RequestMapping("/client")
public class MyClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyClientController.class);

    @Autowired
    private MyClient client;

    @Autowired
    private BaiduApi baiduApi;

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/test")
    public ResponseEntity<Result<String>> get() {
        String s = client.simpleRequest();
        LOGGER.info("{}", s);
//        Map result = client.getLocation("124.730329", "31.463683");
//        System.out.println(JSONUtil.toJsonStr(result));
//        asyncService.asyncMethod();
        return ResponseUtil.buildSuccess();
    }

    @Value("${my.name}")
    private String name;

    @GetMapping("/config")
    public ResponseEntity config() {
        LOGGER.info("name:[{}]", name);
        return null;
    }
}
