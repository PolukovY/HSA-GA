package com.levik.transactions.service;

import com.levik.transactions.client.CryptolionsCient;
import com.levik.transactions.client.model.CryptoRequest;
import com.levik.transactions.client.model.CryptoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CryptolionsService {

    private final CryptolionsCient cryptolionsCient;
    private final GoogleAnalyticsService googleAnalyticsService;


    public void publish(){
        CryptoResponse cryptoResponse = cryptolionsCient.getLastIrreversibleBlock(CryptoRequest.createSimpleRequest());
        Set<String> transactions = cryptoResponse.getActions()
                .stream()
                .filter(CryptoResponse.Action::isIrreversible)
                .map(it -> it.getAccountTrace().getTrxId())
                .collect(Collectors.toSet());

        log.info("Get irreversible transactions size {}", transactions.size());

        transactions.forEach(googleAnalyticsService::send);
    }


}
