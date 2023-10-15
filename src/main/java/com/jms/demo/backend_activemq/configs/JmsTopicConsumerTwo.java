package com.jms.demo.backend_activemq.configs;

import com.jms.demo.backend_activemq.models.JmsDemoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.ObjectMessage;

@Component
@Log4j2
public class JmsTopicConsumerTwo {

    @JmsListener(destination = "${active-mq.topic}")
    public void onMessageConsume(Message message){
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            JmsDemoEntity jmsDemoEntity = (JmsDemoEntity)objectMessage.getObject();
            //do additional processing
            log.info("Received Message from topic: "+ jmsDemoEntity.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}
