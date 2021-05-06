package org.springblade.anbiao.qiyeshouye.springTemplate.basicJsonBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class JsonProducer {
    @Autowired
    @Qualifier("jsonKafkaTemplate")
    private KafkaTemplate<String, JsonBean> kafkaTemplate;

    @Value("${kafka.topic.json}")
    private String topic;

    public void send(JsonBean json) {
        kafkaTemplate.send(topic, json);
    }

}
