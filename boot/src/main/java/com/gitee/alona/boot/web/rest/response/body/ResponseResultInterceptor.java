package com.gitee.alona.boot.web.rest.response.body;

import com.gitee.alona.boot.common.util.SpringContextUtil;
import com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @see ResponseResultHandler
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor, ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultInterceptor.class);

    private Set<Method> methodSet;
    private final BloomFilter<Long> requestMethodBloomFilter = BloomFilter.create(Funnels.longFunnel(), 32, 0.0001);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        LOGGER.info("进入判断是否处理响应体的拦截器");
        if (handler instanceof HandlerMethod) {
            if (!requestMethodBloomFilter.mightContain((long) handler.hashCode())) {
                if (this.methodSet.contains(((HandlerMethod) handler).getMethod())) {
                    ResponseConstant.IS_ANN.set(Boolean.TRUE);
                }
            }
        }
        return true;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 拿到所有的 requestMapping 方法
        Collection<HandlerMethod> handlerMethods = SpringContextUtil.getApplicationContext()
                .getBean(RequestMappingHandlerMapping.class)
                .getHandlerMethods()
                .values();

        this.methodSet = handlerMethods.stream()
                .filter(handlerMethod -> {
                    final Class<?> beanType = handlerMethod.getBeanType();
                    // 判断类或方法上是否有需要包装返回值的注解
                    return (beanType.isAnnotationPresent(ResponseResult.class)
                            || handlerMethod.getMethod().isAnnotationPresent(ResponseResult.class));
                })
                .map(HandlerMethod::getMethod)
                .collect(Collectors.toSet());

        // 不需要包装的类
        handlerMethods.stream()
                .map(HandlerMethod::getMethod)
                .filter(handlerMethod -> !this.methodSet.contains(handlerMethod))
                .forEach(method -> requestMethodBloomFilter.put((long) method.hashCode()));
    }

}
