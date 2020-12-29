package com.levik.transactions.client;


import com.levik.transactions.client.model.CryptoRequest;
import com.levik.transactions.client.model.CryptoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cryptolions", url = "https://wax.greymass.com")
public interface CryptolionsCient {

    @RequestMapping(method = RequestMethod.POST, value = "/v1/history/get_actions")
    CryptoResponse getLastIrreversibleBlock(CryptoRequest cryptoRequest);
}
