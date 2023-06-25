package cn.pdteam.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketMqConfig {
    @Value("${cts.rocketmq.namesrv-addr}")
    String namesrvAddr;
    @Value("${cts.rocketmq.producer-group}")
    String producerGroup;

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(producerGroup);
        defaultMQProducer.setNamesrvAddr(namesrvAddr);
        return defaultMQProducer;
    }
}
