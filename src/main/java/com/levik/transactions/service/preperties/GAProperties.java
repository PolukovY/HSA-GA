package com.levik.transactions.service.preperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
@ConfigurationProperties(value = "ga")
public class GAProperties {

    private int version;
    private String tid;
}
