package com.gitee.alona.boot.web.rest.response.body;

import com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.gitee.alona.boot.web.rest.response.body.ResponseConstant.RESPONSE_RESULT_ANN;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
//@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultInterceptor.class);

//    public ThreadLocal<Future<>>

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("进入判断是否处理响应体的拦截器");
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> beanType = handlerMethod.getBeanType();
            // 判断类或方法上是否有需要包装返回值的注解
            if (beanType.isAnnotationPresent(ResponseResult.class)
                    || handlerMethod.getMethod().isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_RESULT_ANN, Boolean.TRUE);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
