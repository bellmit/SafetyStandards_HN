package org.springblade.anbiao.qiyeshouye.springTemplate.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class TransactionalProducer {
    @Autowired
    @Qualifier("errorTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;


    @Value("${kafka.topic.transactional}")
    private String topic;

    /**
     * 事务发送
     * @param message
     */
    @Transactional
    public void send(String message) {
        kafkaTemplate.send(topic, message);
        throw new RuntimeException("fail");
    }


    /**
     * 使用KafkaTemplate.executeInTransaction开启事务
     *
     * 本地事务，不需要事务管理器
     * @param message
     * @throws InterruptedException
     */
    public void testExecuteInTransaction(String message) throws InterruptedException {
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaOperations.send(topic, message);
                throw new RuntimeException("fail");
                //return true;
            }
        });
    }

}
