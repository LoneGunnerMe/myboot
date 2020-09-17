package com.gitee.alona.boot.common.log.track;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 11:07
 */
//@Configuration
@Deprecated
public class TrackIdConfiguration implements WebMvcConfigurer {

    private final TrackIdInterceptor trackIdInterceptor;

    public TrackIdConfiguration(TrackIdInterceptor trackIdInterceptor) {
        this.trackIdInterceptor = trackIdInterceptor;
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(trackIdInterceptor)
                .addPathPatterns("/**");
    }
}