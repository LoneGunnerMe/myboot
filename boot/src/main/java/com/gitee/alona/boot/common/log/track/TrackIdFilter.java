package com.gitee.alona.boot.common.log.track;

import cn.hutool.core.util.IdUtil;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static com.gitee.alona.boot.common.log.track.TrackIdUtil.TRACK_ID_NAME;
import static com.gitee.alona.boot.common.log.track.TrackIdUtil.getTrackId;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-27 15:53
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "logTrackIdFilter")
public class TrackIdFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put(TRACK_ID_NAME, getTrackId());
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
