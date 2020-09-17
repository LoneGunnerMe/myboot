package com.gitee.alona.boot.common.log.track;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 给 spring @Async 注解修饰的线程添加 traceId
 *
 * @author 孤胆枪手
 */
//@Aspect
//@Component
//@Order(-9999)
@Deprecated
public class TrackIdAsyncAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackIdAsyncAspect.class);

//    @Pointcut("@annotation(org.springframework.scheduling.annotation.Async)")
    @Pointcut("this(org.springframework.scheduling.annotation.Async)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        LOGGER.info("给异步请求添加 trackId");
        String trackId = TrackIdUtil.getTrackId();
        MDC.put(TrackIdUtil.TRACK_ID_NAME, trackId);
        // 执行方法
        return point.proceed();
    }
}