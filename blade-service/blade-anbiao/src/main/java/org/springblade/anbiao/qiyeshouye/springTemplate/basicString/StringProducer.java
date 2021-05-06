package org.springblade.anbiao.qiyeshouye.springTemplate.basicString;

import org.springblade.anbiao.qiyeshouye.springTemplate.basicString.listener.KafkaSendResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;


@Component
public class StringProducer {
    @Autowired
    @Qualifier("stringKafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaSendResultHandler kafkaSendResultHandler;

    @Value("${kafka.topic.basic}")
    private String basicTopic;

	@Value("${kafka.topic.error}")
	private String errorTopic;

	@Value("${kafka.topic.batch}")
	private String batchTopic;

    public void send(String message) {
        kafkaTemplate.send(basicTopic,"", message);
    }

	public void errorsend(String message) {
		kafkaTemplate.send(errorTopic,"", message);
	}

	public void batchsend(String message) {
		kafkaTemplate.send(batchTopic,"", message);
	}

    /**
     * 异步发送
     * @param message
     */
    public void sendAsync(String message) {
        kafkaTemplate.send(basicTopic, message);
    }

    /**
     * 发送回调
     * @param message
     */
    public void sendAndCallback(String message) {
        // 配置发送回调，可选
        kafkaTemplate.setProducerListener(kafkaSendResultHandler);
        kafkaTemplate.send(basicTopic, message);
    }

    /**
     *  同步发送，默认异步
     * @param message
     */
    public void sendSync(String message) {
        try {
            kafkaTemplate.send(basicTopic, message).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
