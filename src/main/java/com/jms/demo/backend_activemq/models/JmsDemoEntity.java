package com.jms.demo.backend_activemq.models;

import jdk.jfr.DataAmount;
import lombok.Data;
import java.io.Serializable;

@Data
public class JmsDemoEntity implements Serializable {

    private static final long serialVersionUID = -275422703255886286L;
    private long demoId;
    private String demoEntityName;
    private String status;
}
