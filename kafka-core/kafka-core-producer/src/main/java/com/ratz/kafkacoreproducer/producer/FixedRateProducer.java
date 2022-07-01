package com.ratz.kafkacoreproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

//@Service
public class FixedRateProducer {

  private static final Logger log = LoggerFactory.getLogger(FixedRateProducer.class.getSimpleName());

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  private AtomicInteger counter = new AtomicInteger();

  //@Scheduled(fixedRate = 1000)
  public void sendMessage(){
    int i = counter.decrementAndGet();
    log.info("I is " + i);
    kafkaTemplate.send("t-fixedrate", "Fixed Rate " + i);
  }
}
