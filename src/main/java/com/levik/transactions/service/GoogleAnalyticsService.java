package com.levik.transactions.service;


import com.levik.transactions.client.GAClient;
import com.levik.transactions.client.model.GARequest;
import com.levik.transactions.service.preperties.GAProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GoogleAnalyticsService {

    private final GAClient gaClient;
    private final GAProperties gaProperties;

    public void send(String id) {
        String clientIdentity = UUID.randomUUID().toString();

        var gaRequest = GARequest.builder()
                .v(gaProperties.getVersion())
                .tid(gaProperties.getTid())
                .cid(clientIdentity)

                //for event
                .t("event")
                .ec("irreversibleTransaction")
                .ea(id)

                // for page
                //.t("pageview")
                //.dp(URLDecoder.decode("/transaction?id=" + id, StandardCharsets.UTF_8))
                //.dt("Transaction title")
                .build();

        gaClient.publish(gaRequest);
    }
}
