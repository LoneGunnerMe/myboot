package com.gitee.alona.boot.web.rest;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.alona.boot.common.util.SpringContextUtil;
import com.gitee.alona.boot.service.AsyncService;
import com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
//@ResponseResult
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/users/{id}/articles")
    public List<String> getAllArticles(@PathVariable String id) {
        return new ArrayList<>();
    }

    @GetMapping("getAllUrl")
    public Object getAllUrl(HttpServletRequest request) {
        Set<String> result = new HashSet<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = SpringContextUtil.getApplicationContext()
                .getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        for (RequestMappingInfo rmi : handlerMethods.keySet()) {
            PatternsRequestCondition pc = rmi.getPatternsCondition();
            Set<String> pSet = pc.getPatterns();
            result.addAll(pSet);
        }
        return result;
    }

    @GetMapping("/ex/ok")
    @ResponseResult
    public Integer ok() {
        Object o = 0;
        return (Integer) o;
    }

    @GetMapping("/ex/error")
    @ResponseResult
    public Object error() {
        throw new RuntimeException("报错啦");
    }

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    @ResponseResult
    public Object async() {
        LOGGER.info("测试异步的 trackId");
        asyncService.asyncMethod();
        return null;
    }

    private void test() {

    }


    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/request")
    @ResponseResult
    public Object testRequest() {

        Object attribute = request.getParameter("name");
        LOGGER.info("attr: [{}]", attribute);
        return ResponseEntity.ok(attribute);
    }

    @PostMapping("/jsonDate")
    @ResponseResult
    public Object jsonDate(@RequestBody RequestDateDTO requestDateDTO) {
        LOGGER.info("requestDateDTO：{}", requestDateDTO);
        return 0;
    }

    public static class RequestDateDTO {

        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime localDateTime;

        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        Date date;

        String name;

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "RequestDateDTO{" + "localDateTime=" + localDateTime +
                    ", date=" + date +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
