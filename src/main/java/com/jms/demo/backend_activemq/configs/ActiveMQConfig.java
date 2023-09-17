package com.jms.demo.backend_activemq.configs;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
public class ActiveMQConfig {
  @Value("${active-mq.broker-url}")
  private String brokerUrl;

    /**
     * This method will set activemq
     * connection factory object
     * this used for producer
     * @return ConnectionFactory
     */
  @Bean
  public ConnectionFactory connectionFactory() {
      ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
      //setting active mq broker url
      connectionFactory.setBrokerURL(brokerUrl);
      connectionFactory.setTrustedPackages(Arrays.asList("com.jms.demo.backend_activemq"));
      return connectionFactory;
  }

    /**
     * This method will return
     * JmsTemplate object
     * here we are setting the
     * connectionFactory object of ActiveMq
     * @return
     */
  @Bean
    public JmsTemplate jmsTemplate(){
      JmsTemplate jmsTemplate = new JmsTemplate();
      jmsTemplate.setConnectionFactory(connectionFactory());
      jmsTemplate.setPubSubDomain(true);
      return  jmsTemplate;
  }

    /**
     * This method will set activemq
     * connection factory object
     * this used for consumer
     * @return ConnectionFactory
     */
//    @Bean
//    public ConnectionFactory connectionFactoryConsumer(){
//        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL(brokerUrl);
//        activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.jms.demo.backend_activemq"));
//        return  activeMQConnectionFactory;
//    }

    /**
     * This method return
     * Jms Listener object which
     * used in jms consumer
     * @return
     */
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPubSubDomain(true);
        return factory;
    }
}
