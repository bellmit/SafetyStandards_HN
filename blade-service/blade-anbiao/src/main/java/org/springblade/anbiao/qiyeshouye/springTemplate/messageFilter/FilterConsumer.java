package org.springblade.anbiao.qiyeshouye.springTemplate.messageFilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * 消息过滤
 */
@Component
@Slf4j
public class FilterConsumer {

    @KafkaListener(topics = "${kafka.topic.filter}", containerFactory = "filterKafkaListenerContainerFactory")
    public void receiveString(String message, Acknowledgment ack) {
        System.out.println(String.format("Message : %s", message));
        ack.acknowledge();
    }

}
