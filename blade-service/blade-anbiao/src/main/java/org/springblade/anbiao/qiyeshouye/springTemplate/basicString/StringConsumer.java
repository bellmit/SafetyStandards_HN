package org.springblade.anbiao.qiyeshouye.springTemplate.basicString;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * https://www.jianshu.com/p/a64defb44a23 @KafkaListener多种使用方式
 */
@Component
@Slf4j
public class StringConsumer {

//    @KafkaListener(topics = "${kafka.topic.basic}", containerFactory = "stringKafkaListenerContainerFactory")
    public void receiveString(String message) {
        System.out.println(String.format("Message : %s", message));
    }


    /**
     * 注解方式获取消息头及消息体
     *
     * @Payload：获取的是消息的消息体，也就是发送内容
     * @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY)：获取发送消息的key
     * @Header(KafkaHeaders.RECEIVED_PARTITION_ID)：获取当前消息是从哪个分区中监听到的
     * @Header(KafkaHeaders.RECEIVED_TOPIC)：获取监听的TopicName
     * @Header(KafkaHeaders.RECEIVED_TIMESTAMP)：获取时间戳
     *
     */
    //    @KafkaListener(topics = "${kafka.topic.basic}", containerFactory = "stringKafkaListenerContainerFactory")
    public void receive(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) {
        System.out.println(String.format("From partition %d : %s", partition, message));
    }

    /**
     * 指定消费分区和初始偏移量
     *
     * @TopicPartition：topic--需要监听的Topic的名称，partitions --需要监听Topic的分区id，partitionOffsets --可以设置从某个偏移量开始监听
     * @PartitionOffset：partition --分区Id，非数组，initialOffset --初始偏移量
     *
     */
//    @KafkaListener(
//            containerFactory = "stringKafkaListenerContainerFactory",
//            topicPartitions = @TopicPartition(
//                    topic = "${kafka.topic.basic}",
//                    partitionOffsets = @PartitionOffset(
//                            partition = "0" ,
//                            initialOffset = "0")))
    public void receiveFromBegin(@Payload String payload,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(String.format("Read all message from partition %d : %s", partition, payload));
    }

    /**
     * ConsumerRecord 接收
     *
     * @param record
     */
//    @KafkaListener(topics = "${kafka.topic.basic}", containerFactory = "stringKafkaListenerContainerFactory")
    public void receive(ConsumerRecord<?, ?> record) {
        System.out.println("Message is :" + record.toString());
    }

}
