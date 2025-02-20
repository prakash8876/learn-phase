package io.matoshri.learn.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private static final String KAFKA_TOPIC = "learn-topic";
    private static final String KAFKA_GROUP = "group-id";


    @KafkaListener(topics = KAFKA_TOPIC, groupId = KAFKA_GROUP)
    public void consume(String message) {
        logger.info("#### -> Consumed message -> {}", message);
    }
}
