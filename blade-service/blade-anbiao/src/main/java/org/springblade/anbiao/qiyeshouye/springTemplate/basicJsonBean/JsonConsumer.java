package org.springblade.anbiao.qiyeshouye.springTemplate.basicJsonBean;

import org.springframework.stereotype.Component;


@Component
public class JsonConsumer {

//    @KafkaListener(topics = "${kafka.topic.json}", containerFactory = "basicKafkaListenerContainerFactory")
    public void receive(JsonBean basic) {
        System.out.println("receive:" + basic.toString());
    }
}
