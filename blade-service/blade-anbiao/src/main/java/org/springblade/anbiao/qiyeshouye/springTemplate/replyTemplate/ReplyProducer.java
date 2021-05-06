package org.springblade.anbiao.qiyeshouye.springTemplate.replyTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class ReplyProducer {
    @Autowired
    @Qualifier("replyKafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.reply}")
    private String topic;

    public void send(String message) {
        kafkaTemplate.send(topic, message);
    }

}
