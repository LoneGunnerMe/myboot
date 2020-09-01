package com.gitee.alona.boot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-02 13:30
 */
@Configuration
@MapperScan("com.gitee.alona.boot.dao")
public class MybatisPlusConfiguration {
}
