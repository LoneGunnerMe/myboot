package com.gitee.alona.boot.web.rest.response.body;

import com.gitee.alona.boot.web.rest.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 包装返回值
 * 注意：如果 controller 中返回的是 String 会报类型转换错误
 *
 * @author 孤胆枪手
 * @version 1.0
 * @see org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor#writeWithMessageConverters(Object, MethodParameter, ServletServerHttpRequest, ServletServerHttpResponse)
 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
 */
@Component
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultHandler.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return ResponseConstant.IS_ANN.get();
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResponseConstant.IS_ANN.remove();
        LOGGER.info("进入响应体处理");
        // 如果是body是响应实体类，就直接返回
        if (body instanceof Result) {
            return body;
        }
        return new Result<>("ok", 200, body);
    }
}
