package org.springblade.anbiao.qiyeshouye.springTemplate.basicString.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author 司马缸砸缸了
 * @date 2019/12/30 10:53
 * @description 消息回调监听器
 */
@Component
@Slf4j
public class KafkaSendResultHandler implements ProducerListener {
    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Message send success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info("Message send error : " + exception);
    }

    /**
     *
     * @return true 代表成功也会调用onSuccess，默认为false
     */
    @Override
    public boolean isInterestedInSuccess() {
        return false;
    }

}
