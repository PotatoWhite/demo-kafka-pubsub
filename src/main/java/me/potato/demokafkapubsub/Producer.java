package me.potato.demokafkapubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    private static String TOPIC = "kafka";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String data) {
        log.info("Produce Topic: %s - Message: %s", TOPIC, data);
        this.kafkaTemplate.send(TOPIC, data);
    }
}
