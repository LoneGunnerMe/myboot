package com.gitee.alona.boot.web.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 23:41
 */
public final class ResponseUtil {

    private static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "操作成功";

    private static final int CODE_ERROR = 500;

    private static final Result<?> SUCCESS_RESULT = new Result<>(SUCCESS_MSG, SUCCESS_CODE, null);

    public static <D> ResponseEntity<Result<D>> buildSuccess() {
        return ResponseEntity.ok((Result<D>) SUCCESS_RESULT);
    }

    public static <D> ResponseEntity<Result<D>> buildSuccess(D d) {
        return ResponseEntity.ok(new Result<>(SUCCESS_MSG, SUCCESS_CODE, d));
    }

    public static <D> ResponseEntity<Result<D>> buildNotFound(D d) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Result<>(SUCCESS_MSG, SUCCESS_CODE, d));
    }


    private ResponseUtil() {
    }
}
