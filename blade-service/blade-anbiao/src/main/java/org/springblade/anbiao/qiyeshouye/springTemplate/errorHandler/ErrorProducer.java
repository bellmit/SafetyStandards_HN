package org.springblade.anbiao.qiyeshouye.springTemplate.errorHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class ErrorProducer {
    @Autowired
    @Qualifier("errorTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;


    @Value("${kafka.topic.error}")
    private String topic;

    public void send(String message) {
        kafkaTemplate.send(topic, message);
    }

}
