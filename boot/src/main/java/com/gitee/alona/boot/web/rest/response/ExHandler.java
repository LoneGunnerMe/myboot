package com.gitee.alona.boot.web.rest.response;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @author 孤胆枪手
 * @version 1.0
 */
@RestControllerAdvice
public class ExHandler {

    @ExceptionHandler(Throwable.class)
    public ErrorResult<String> handler(Throwable throwable) {
        return new ErrorResult<>("系统异常", 500, throwable.getMessage());
    }
}
