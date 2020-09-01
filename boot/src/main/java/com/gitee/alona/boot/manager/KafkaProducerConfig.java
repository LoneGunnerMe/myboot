package com.gitee.alona.boot.manager;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.io.Serializable;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
@Configuration
public class KafkaProducerConfig {

    @Autowired
    KafkaProperties kafkaProperties;

    @Bean
    public KafkaProducer<String, Serializable> kafkaProducer() {
        return new KafkaProducer(kafkaProperties.getProducer().buildProperties());
    }

//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}
