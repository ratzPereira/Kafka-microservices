package com.ratz.kafkacoreconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRateConsumerV2 {

  private static  final Logger log = LoggerFactory.getLogger(FixedRateConsumerV2.class.getSimpleName());

  @KafkaListener(topics = "t-fixedrate-2")
  public void consume(String message){
    log.info("Consuming : {} ", message);
  }
}
