package com.gitee.alona.boot.manager.config;

import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 9:15
 */
@Configuration
@ForestScan(basePackages = "com.gitee.alona.boot.manager.api")
public class ForestConfig {
}
