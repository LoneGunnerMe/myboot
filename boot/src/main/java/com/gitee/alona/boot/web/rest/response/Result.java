package com.gitee.alona.boot.web.rest.response;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 返回对象封装类
 *
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-23 15:53
 */
public class Result<T> {

    private String msg;
    private Integer code;
    private T data;

    public Result(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(getMsg(), result.getMsg()) &&
                Objects.equals(getCode(), result.getCode()) &&
                Objects.equals(getData(), result.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMsg(), getCode(), getData());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")
                .add("msg='" + msg + "'")
                .add("code=" + code)
                .add("data=" + data)
                .toString();
    }
}