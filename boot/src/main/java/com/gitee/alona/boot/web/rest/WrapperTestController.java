package com.gitee.alona.boot.web.rest;

import com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
@RestController
@RequestMapping("/test/wrapper")
public class WrapperTestController {

    @GetMapping("/wrapper")
    @ResponseResult
    public Integer wrapper() {
        Object o = 0;
        return (Integer) o;
    }

    @GetMapping("/noWrapper")
    public Integer noWrapper() {
        Object o = 0;
        return (Integer) o;
    }

}
