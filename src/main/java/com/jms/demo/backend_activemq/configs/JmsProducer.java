package com.jms.demo.backend_activemq.configs;

import com.jms.demo.backend_activemq.models.JmsDemoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JmsProducer {
  @Value("${active-mq.topic}")
  private String topic;

  @Autowired JmsTemplate jmsTemplate;

  public void sendMessage(JmsDemoEntity jmsDemoEntity){
    log.info("Attempting to send message to topic {}", topic);
    try{
        jmsTemplate.convertAndSend(topic, jmsDemoEntity);
    }catch (Exception e){
        log.error("error in sending message {}", e.getMessage());
    }
  }
}
