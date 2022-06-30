package com.ratz.kafkacoreproducer;

import com.ratz.kafkacoreproducer.producer.HelloKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class KafkaCoreProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloKafkaProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("Ratz" + ThreadLocalRandom.current().nextInt());
	}
}
