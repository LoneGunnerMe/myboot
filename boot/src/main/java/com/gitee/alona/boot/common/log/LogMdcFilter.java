package com.gitee.alona.boot.common.log;

import cn.hutool.core.util.IdUtil;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 15:53
 */
//@Component
//@WebFilter(urlPatterns = "/*", filterName = "logTrackIdFilter")
public class LogMdcFilter implements Filter {
    private static final String TRACK_ID_NAME = "trackId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(TRACK_ID_NAME, IdUtil.createSnowflake(0L, 0L).nextIdStr());
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(TRACK_ID_NAME);
        }
    }

    @Override
    public void destroy() {

    }
}
