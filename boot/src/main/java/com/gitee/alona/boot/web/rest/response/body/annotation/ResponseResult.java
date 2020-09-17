package com.gitee.alona.boot.web.rest.response.body.annotation;

import java.lang.annotation.*;

/**
 * 包装统一的响应数据结构
 *
 * @author 孤胆枪手
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ResponseResult {

}
