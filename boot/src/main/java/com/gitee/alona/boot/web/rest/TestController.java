package com.gitee.alona.boot.web.rest;

import com.gitee.alona.boot.service.AsyncService;
import com.gitee.alona.boot.web.rest.response.body.annotation.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
@ResponseResult
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/users/{id}/articles")
    public List<String> getAllArticles(@PathVariable String id) {
        return new ArrayList<>();
    }

    @Autowired
    private RequestMappingHandlerMapping bean;

    @GetMapping("getAllUrl")
    public Object getAllUrl(HttpServletRequest request) {
        Set<String> result = new HashSet<String>();
//        WebApplicationContext wc = (WebApplicationContext) request.getAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//        RequestMappingHandlerMapping bean = wc.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean.getHandlerMethods();
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
}
