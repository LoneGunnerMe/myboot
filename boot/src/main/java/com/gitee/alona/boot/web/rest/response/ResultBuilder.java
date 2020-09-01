package com.gitee.alona.boot.web.rest.response;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-23 15:54
 */
public final class ResultBuilder<T> {

    private String msg;
    private Integer code;
    private T data;

    private ResultBuilder() {
    }

    public static <T> ResultBuilder<T> create() {
        return new ResultBuilder<>();
    }

    public ResultBuilder<T> withMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultBuilder<T> withCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResultBuilder<T> withData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> build() {
        return new Result<>(msg, code, data);
    }
}
