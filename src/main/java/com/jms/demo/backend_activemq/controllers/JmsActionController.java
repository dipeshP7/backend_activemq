package com.jms.demo.backend_activemq.controllers;

import com.jms.demo.backend_activemq.configs.JmsProducer;
import com.jms.demo.backend_activemq.models.JmsDemoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jms/v1")
public class JmsActionController {

  @Autowired JmsProducer jmsProducer;
  @GetMapping("/init")
  public ResponseEntity<String> initMethod() {
        return ResponseEntity.ok("init method called successfully");
  }

  @PostMapping(value = "/api/demo")
  public JmsDemoEntity sendMessage(@RequestBody JmsDemoEntity jmsDemoEntity) {
        jmsProducer.sendMessage(jmsDemoEntity);
        return jmsDemoEntity;
    }
}
