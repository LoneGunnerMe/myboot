package com.gitee.alona.boot.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;


/**
 * @author 孤胆枪手
 * @version 1.0
 */
@EnableCaching

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({Caching.class, RedisCacheManager.class, RedisConnectionFactory.class})
@AutoConfigureAfter(RedisAutoConfiguration.class)
@ConditionalOnMissingBean(CacheManager.class)
//@ConditionalOnBean(RedisConnectionFactory.class)
public class MyRedisCacheConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRedisCacheConfiguration.class);

//    @Bean
//    @Deprecated
//    public CacheManager redisCacheManager(RedisConnectionFactory factory) {
//        LOGGER.info("初始化 redisCacheManager");
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()))
//                .prefixCacheNameWith("CACHE::")
//                .entryTtl(Duration.ofSeconds(0));
//        RedisCacheConfiguration initredisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()))
//                .prefixCacheNameWith("CACHE::")
//                .entryTtl(Duration.ofSeconds(500));
//        Map<String, RedisCacheConfiguration> initConfigMap = new LinkedHashMap<>();
//        initConfigMap.put("string", initredisCacheConfiguration);
//        return new RedisCacheManager(RedisCacheWriter.lockingRedisCacheWriter(factory),
//                redisCacheConfiguration, initConfigMap);
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.json());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

//    @Bean
//    public RedisCacheManager cacheManager(CacheProperties cacheProperties,
//                                          CacheManagerCustomizers cacheManagerCustomizers,
//                                          ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration,
//                                          ObjectProvider<RedisCacheManagerBuilderCustomizer> redisCacheManagerBuilderCustomizers,
//                                          RedisConnectionFactory redisConnectionFactory) {
////        RedisCacheManager redisCacheManager = new MyRedisCacheManager(RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory),
////                determineConfiguration(cacheProperties, redisCacheConfiguration), );
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(determineConfiguration(cacheProperties, redisCacheConfiguration))
//                .cacheWriter(RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory));
//        List<String> cacheNames = cacheProperties.getCacheNames();
//        if (!cacheNames.isEmpty()) {
//            builder.initialCacheNames(new LinkedHashSet<>(cacheNames));
//        }
//        redisCacheManagerBuilderCustomizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
//        return cacheManagerCustomizers.customize(builder.build());
//    }
//
//    private RedisCacheConfiguration determineConfiguration(
//            CacheProperties cacheProperties,
//            ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration) {
//        return redisCacheConfiguration.getIfAvailable(() -> createConfiguration(cacheProperties));
//    }
//
//    private RedisCacheConfiguration createConfiguration(CacheProperties cacheProperties) {
//        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
//        RedisCacheConfiguration config = RedisCacheConfiguration
//                .defaultCacheConfig();
//        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
//        if (redisProperties.getTimeToLive() != null) {
//            config = config.entryTtl(redisProperties.getTimeToLive());
//        }
//        if (redisProperties.getKeyPrefix() != null) {
//            config = config.prefixCacheNameWith(redisProperties.getKeyPrefix());
//        }
//        if (!redisProperties.isCacheNullValues()) {
//            config = config.disableCachingNullValues();
//        }
//        if (!redisProperties.isUseKeyPrefix()) {
//            config = config.disableKeyPrefix();
//        }
//        return config;
//    }

}
