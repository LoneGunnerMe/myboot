package com.gitee.alona.boot.common.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.gitee.alona.boot.common.log.LogConstant.*;

/**
 * @author Xingbz
 */
@Aspect
@Component
public class LogMdcAspect {

    @Pointcut("@annotation(org.springframework.scheduling.annotation.Async)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MDC.put(TRACK_ID_NAME, UUID.randomUUID().toString().replace("-", ""));
        // 执行方法
        Object result = point.proceed();
        MDC.remove(TRACK_ID_NAME);
        return result;
    }
}