package me.potato.demokafkapubsub;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootApplication
public class Application {

	public Application( ProducerFactory producerFactory) {
		this.producerFactory = producerFactory;

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private ProducerFactory producerFactory;

	@Bean
	public NewTopic adviceTopic() {
		return new NewTopic("kafka", 1, (short)1);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(){
		KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
		return kafkaTemplate;
	}
}
