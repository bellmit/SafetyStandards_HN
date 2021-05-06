package org.springblade.anbiao.qiyeshouye.springTemplate.batch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class BatchConsumerConfig {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.topic.batch}")
    private String topic;

    /**
     * 多线程-批量消费
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<?> batchFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        // 控制多线程消费
        // 并发数(如果topic有3各分区。设置成3，并发数就是3个线程，加快消费)
        // 不设置setConcurrency就会变成单线程配置, MAX_POLL_RECORDS_CONFIG也会失效，
        // 接收的消息列表也不会是ConsumerRecord
        factory.setConcurrency(10);
        // poll超时时间
        factory.getContainerProperties().setPollTimeout(1500);
        // 控制批量消费
        // 设置为批量消费，每个批次数量在Kafka配置参数中设置（max.poll.records）
        factory.setBatchListener(true);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    /**
     * 消费者配置
     * @return
     */
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        // 不用指定全部的broker，它将自动发现集群中的其余的borker, 最好指定多个，万一有服务器故障
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // key序列化方式
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // value序列化方式
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // GroupID
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        // 批量消费消息数量
        configProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 2);

        // -----------------------------额外配置，可选--------------------------

        // 自动提交偏移量
        // 如果设置成true,偏移量由auto.commit.interval.ms控制自动提交的频率
        // 如果设置成false,不需要定时的提交offset，可以自己控制offset，当消息认为已消费过了，这个时候再去提交它们的偏移量。
        // 这个很有用的，当消费的消息结合了一些处理逻辑，这个消息就不应该认为是已经消费的，直到它完成了整个处理。
        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        // 自动提交的频率
        configProps.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // Session超时设置
        configProps.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");

        // 该属性指定了消费者在读取一个没有偏移量的分区或者偏移量无效的情况下该作何处理：
        // latest（默认值）在偏移量无效的情况下，消费者将从最新的记录开始读取数据（在消费者启动之后生成的记录）
        // earliest ：在偏移量无效的情况下，消费者将从起始位置读取分区的记录
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        return configProps;
    }

}
