package com.gitee.alona.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 10:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogTest {
private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void log() {
        LOGGER.trace("A TRACE Message");
        LOGGER.debug("A DEBUG Message");
        LOGGER.info("An INFO Message");
        LOGGER.warn("A WARN Message");
        LOGGER.error("An ERROR Message");
    }
}
