package com.gitee.alona.boot.web.rest.response.body;

import com.gitee.alona.boot.web.rest.response.ErrorResult;
import com.gitee.alona.boot.web.rest.response.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

/**
 * 包装返回值的切面
 * 如果使用这种方式，那么 controller 中方法的返回值只能是 Object，
 * 否则会报类型转换的异常，
 * 我觉得不优雅，所以暂且不用他
 *
 * @author 孤胆枪手
 * @version 1.0
 */
//@Aspect
//@Component
@Deprecated
public class WrapperResponseAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(WrapperResponseAspect.class);

    /**
     * 类上和方法上有 {@link com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult} 注解
     */
    @Pointcut("execution(@com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult public * *(..))" +
            "|| @within(com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object wrapper(ProceedingJoinPoint joinPoint) throws Throwable {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("AOP 切面包装返回值");
        }
        try {
            Object result = joinPoint.proceed();
            return new Result<>("ok", 200, result);

            // 这里需要判断一下异常的类型
            // 然后根据不同的异常返回不同的错误提示和错误码
            // 这样写可能会比较繁琐而且复杂，统一异常处理就不太好使了
            // emmm 比较复杂
        } catch (FileNotFoundException e) {
            LOGGER.error("异常", e);
            return new ErrorResult<>("文件不存在异常", 500, e.getLocalizedMessage());
        } catch (Exception e) {
            LOGGER.error("异常", e);
            return new ErrorResult<>("系统错误", 500, e.getLocalizedMessage());
        } catch (Throwable e) {
            LOGGER.error("异常", e);
            return new ErrorResult<>("超级错误", 500, e.getLocalizedMessage());
        }
    }
}
