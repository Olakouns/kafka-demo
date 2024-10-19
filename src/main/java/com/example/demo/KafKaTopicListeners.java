package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafKaTopicListeners {
    private final Logger logger = LoggerFactory.getLogger(KafKaTopicListeners.class);

    @KafkaListener(topics = {"task-topic"}, groupId = "task-group")
    public void consume(TaskStatus taskStatus) {

        logger.info(String.format("Task status is updated : " + taskStatus));
    }
}
