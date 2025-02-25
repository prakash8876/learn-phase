package io.matoshri.learn.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class Producer {

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Value("${learn.kafka.topic}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("### Sending message: [{}]", message);
        this.kafkaTemplate.send(kafkaTopic, message);
        log.info("### Message sent successfully.");
    }
}
