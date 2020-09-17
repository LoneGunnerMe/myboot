package com.gitee.alona.boot.web.rest.response;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
public class ErrorResult<T> extends Result<T> {

    public ErrorResult(String msg, Integer code, T data) {
        super(msg, code, data);
    }

}
