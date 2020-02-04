package me.potato.demokafkapubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = "kafka", groupId = "myGroup")
    public void consume(String message) throws IOException {
        log.info("Consume Message: {}", message);
    }
}
