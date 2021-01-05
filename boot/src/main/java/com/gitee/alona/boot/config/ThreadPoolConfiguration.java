package com.gitee.alona.boot.config;

import com.baomidou.mybatisplus.extension.api.R;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 自定义一个线程池
 *
 * @author 孤胆枪手
 * @version 1.0
 */
//@Configuration
//@EnableAsync
public class ThreadPoolConfiguration {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor() {
            @Override
            public void execute(Runnable task) {
                Map<String, String> contextMap = MDC.getCopyOfContextMap();
                super.execute(() -> {
                    MDC.setContextMap(contextMap);
                    try {
                        // 执行异步操作
                        task.run();
                    } finally {
                        // 清空MDC内容
                        MDC.clear();
                    }
                });
            }
        };
    }

    @Bean
    public ExecutorService executorService(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(4, 8, 5000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(20), threadFactory);
    }

    @Bean
    public ThreadFactory threadFactory() {
        return runnable -> new Thread(runnable, "exec-");
    }
}
