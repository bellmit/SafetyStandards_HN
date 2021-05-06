package org.springblade.anbiao.qiyeshouye.springTemplate.replyTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 转发消息
 */
@Component
@Slf4j
public class ReplyConsumer {

    @KafkaListener(topics = "${kafka.topic.reply}", containerFactory = "replyKafkaListenerContainerFactory")
    @SendTo("reply_to_topic")
    public String receiveString(String message) {
        System.out.println(String.format("Message : %s", message));
        return "reply : " + message;
    }

    @KafkaListener(topics = "${kafka.topic.reply.to}", containerFactory = "replyKafkaListenerContainerFactory")
    public void receiveStringTo(String message) {
        System.out.println(String.format("Message to : %s", message));
    }

}
