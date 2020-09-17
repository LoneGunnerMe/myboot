package com.gitee.alona.boot.common.log.track;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志拦截器
 *
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 11:02
 */
@Component
@Order(0)
public class TrackIdInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackIdInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("插入 TrackId");
        String trackId = TrackIdUtil.getTrackId();
        MDC.put(TrackIdUtil.TRACK_ID_NAME, trackId);
        response.setHeader("ETag-request-id", trackId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOGGER.info("删除 TrackId");
        MDC.remove(TrackIdUtil.TRACK_ID_NAME);
        TrackIdUtil.removeTrackId();
    }

}
