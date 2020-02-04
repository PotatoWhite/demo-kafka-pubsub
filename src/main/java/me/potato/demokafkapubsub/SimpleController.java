package me.potato.demokafkapubsub;

import lombok.extern.slf4j.Slf4j;
import me.potato.demokafkapubsub.model.Simple;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SimpleController {

    private Producer producer;

    public SimpleController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/kafka/publish")
    public ResponseEntity sendMessageToKafka(@RequestBody Simple simple)  {
        log.info(simple.toString());
        producer.produce(simple.getData());

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
