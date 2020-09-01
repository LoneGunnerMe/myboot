package com.gitee.alona.boot.common.log;

import cn.hutool.core.util.IdUtil;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.gitee.alona.boot.common.log.LogConstant.*;

/**
 * 日志拦截器
 *
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 11:02
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        MDC.put(SESSION_ID_NAME, UUID.randomUUID().toString().replaceAll("-", ""));
        String trackId = IdUtil.createSnowflake(0L, 0L).nextIdStr();
        MDC.put(TRACK_ID_NAME, trackId);
        response.setHeader("ETag-request-id", trackId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(TRACK_ID_NAME);
    }

}
