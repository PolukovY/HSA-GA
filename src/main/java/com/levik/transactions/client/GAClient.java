package com.levik.transactions.client;

import com.levik.transactions.client.model.GARequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ga", url = "https://www.google-analytics.com/")
public interface GAClient {

    @RequestMapping(method = RequestMethod.GET, value = "/collect")
    void publish(@SpringQueryMap GARequest gaRequest);
}
