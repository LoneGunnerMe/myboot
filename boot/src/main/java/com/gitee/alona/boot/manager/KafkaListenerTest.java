package com.gitee.alona.boot.manager;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
public class KafkaListenerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerTest.class);
    @Autowired
    private KafkaProducer<String, Serializable> kafkaProducer;

    private static final String TOPIC = "test-kafka-listener";

    /**
     * 要使用多个客户端都消费同一个 topic 的每一个消息，
     * auto-offset-reset: latest
     *
     * @param body
     */
    @KafkaListener(topics = {TOPIC}, groupId = "#{T(java.util.UUID).randomUUID().toString()}")
    public void kafka(String body) {
        System.out.println("KafkaListener...1");
    }

    @KafkaListener(topics = {TOPIC}, groupId = "#{T(java.util.UUID).randomUUID().toString()}")
    public void kafka2(String body) {
        System.out.println("KafkaListener...2");
    }

    @GetMapping("/kafka")
    public ResponseEntity kafkaProd() {
        ProducerRecord<String, Serializable> producerRecord = new ProducerRecord<>(TOPIC, "TEST");
        kafkaProducer.send(producerRecord);
        return null;
    }
}
