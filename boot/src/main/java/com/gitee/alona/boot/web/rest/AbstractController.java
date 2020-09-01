package com.gitee.alona.boot.web.rest;

import com.gitee.alona.boot.service.BaseService;
import com.gitee.alona.boot.web.rest.response.ResponseUtil;
import com.gitee.alona.boot.web.rest.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 23:32
 */
public abstract class AbstractController<D, S extends BaseService<D, ?, ?>> {

    @Autowired
    private S service;

    @PostMapping
    public ResponseEntity<Result<D>> create(D d) {
        return ResponseUtil.buildSuccess(service.create(d));
    }

    @PatchMapping
    public ResponseEntity<Result<D>> update(D d) {
        service.update(d);
        return ResponseUtil.buildSuccess();
    }

    @DeleteMapping
    public ResponseEntity<Result<D>> delete(Serializable id) {
        service.delete(id);
        return ResponseUtil.buildSuccess();
    }
}
