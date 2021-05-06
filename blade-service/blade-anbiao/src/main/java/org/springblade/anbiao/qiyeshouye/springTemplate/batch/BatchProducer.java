package org.springblade.anbiao.qiyeshouye.springTemplate.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;


@Component
public class BatchProducer {
    @Autowired
    @Qualifier("batchKafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.batch}")
    private String batchTopic;

    /**
     * 异步发送
     * @param message
     */
    public void send(String message) {
        kafkaTemplate.send(batchTopic, message);
    }

    /**
     *  同步发送，默认异步
     * @param message
     */
    public void sendSync(String message) {
        try {
            kafkaTemplate.send(batchTopic, message).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
