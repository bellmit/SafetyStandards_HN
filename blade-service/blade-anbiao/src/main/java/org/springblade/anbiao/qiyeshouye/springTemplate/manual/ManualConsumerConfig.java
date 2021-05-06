package org.springblade.anbiao.qiyeshouye.springTemplate.manual;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class ManualConsumerConfig {
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.topic.manual}")
    private String topic;

    @Bean
    public KafkaListenerContainerFactory<?> manualKafkaListenerContainerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "manual-group");
        // 手动提交
        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(configProps));
        // ack模式，详细见下文注释
//        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

        return factory;
    }

    /**
     * AckMode针对ENABLE_AUTO_COMMIT_CONFIG=false时生效，有以下几种：
     *
     * RECORD
     * 每处理一条commit一次
     *
     * BATCH(默认)
     * 每次poll的时候批量提交一次，频率取决于每次poll的调用频率
     *
     * TIME
     * 每次间隔ackTime的时间去commit(跟auto commit interval有什么区别呢？)
     *
     * COUNT
     * 累积达到ackCount次的ack去commit
     *
     * COUNT_TIME
     * ackTime或ackCount哪个条件先满足，就commit
     *
     * MANUAL
     * listener负责ack，但是背后也是批量上去
     *
     * MANUAL_IMMEDIATE
     * listner负责ack，每调用一次，就立即commit
     *
     */

}
