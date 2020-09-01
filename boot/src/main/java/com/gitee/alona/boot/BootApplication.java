package com.gitee.alona.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * boot
 *
 * @author 孤胆枪手
 */
@SpringBootApplication
@RestController
@RequestMapping("/sys")
public class BootApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(BootApplication.class);

    private static ConfigurableApplicationContext context;
    private static String[] args;

    public static void main(String[] args) {
        BootApplication.args = args;
        BootApplication.context = SpringApplication.run(BootApplication.class, args);
        LOGGER.info("Ohhhhhhhhhh 它居然跑起来了");
    }

}
