package com.ratz.kafkacoreproducer;

import com.ratz.kafkacoreproducer.producer.HelloKafkaProducer;
import com.ratz.kafkacoreproducer.producer.KafkaKeyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class KafkaCoreProducerApplication implements CommandLineRunner {

	@Autowired
	KafkaKeyProducer kafkaKeyProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaCoreProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 30; i++) {
			String  key = "Key- " + (i % 4);
			String value = "value" + i + " with key " + key;

			kafkaKeyProducer.send(key,value);
		}

	}
}
