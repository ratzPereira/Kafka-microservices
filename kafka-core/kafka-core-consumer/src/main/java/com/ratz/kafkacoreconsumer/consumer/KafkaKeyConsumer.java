package com.ratz.kafkacoreconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaKeyConsumer {

  private static final Logger log = LoggerFactory.getLogger(KafkaKeyConsumer.class.getSimpleName());

  @KafkaListener(topics = "t-multi-partition", concurrency = "3")
  public void consume(ConsumerRecord<String, String> consumerRecord) throws InterruptedException {

    log.info("Key : {}, Partition : {}, Message : {}", consumerRecord.key(), consumerRecord.partition(), consumerRecord.value());

    TimeUnit.SECONDS.sleep(1);
  }
}
