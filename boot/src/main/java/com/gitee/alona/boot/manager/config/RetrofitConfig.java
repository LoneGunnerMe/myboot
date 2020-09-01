package com.gitee.alona.boot.manager.config;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-28 14:56
 */
@Configuration
@RetrofitScan("com.gitee.alona.boot.manager.api")
public class RetrofitConfig {
}
