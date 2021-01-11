package com.gitee.alona.boot.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringCacheTestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCacheTestService.class);

    @Cacheable(cacheNames = "list#1000")
    public List<String> list() {
        LOGGER.info("从方法里读的");
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("b");
        strings.add("C");
        return strings;
    }

    @Cacheable(cacheNames = "string#500", key = "#s.length()")
    public List<String> string(String s) {
        LOGGER.info("从方法里读的:{}", s);
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("b");
        strings.add("C");
        strings.add(s);
        return strings;
    }

    @Cacheable(cacheNames = "nonExpiredKey", key = "#s.length()")
    public List<String> nonExpiredKey(String s) {
        LOGGER.info("从方法里读的:{}", s);
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("b");
        strings.add("C");
        strings.add(s);
        return strings;
    }
}