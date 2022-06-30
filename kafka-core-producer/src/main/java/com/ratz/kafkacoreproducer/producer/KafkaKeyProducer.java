package com.ratz.kafkacoreproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaKeyProducer {

  private static final Logger log = LoggerFactory.getLogger(KafkaKeyProducer.class.getSimpleName());

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;


  public void send(String key, String value){

    kafkaTemplate.send("t-multi-partitions", key,value);
    log.info("Write key {} and Value {}", key,value);
  }
}
