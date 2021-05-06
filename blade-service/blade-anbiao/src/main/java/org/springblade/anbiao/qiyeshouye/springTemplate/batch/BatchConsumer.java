package org.springblade.anbiao.qiyeshouye.springTemplate.batch;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class BatchConsumer {

    /**
     * 批量消息
     * @param records
     */
//    @KafkaListener(topics = "${kafka.topic.batch}", containerFactory="batchFactory")
    public void consumerBatch(List<ConsumerRecord<?, ?>> records){
        log.info("接收到消息数量：{}",records.size());
        for(ConsumerRecord record: records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            log.info("Received: " + record);
            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                String topic = record.topic();
                System.out.println("接收到消息：" + message);
            }
        }
    }

}
