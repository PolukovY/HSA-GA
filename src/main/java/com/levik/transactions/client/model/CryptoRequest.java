package com.levik.transactions.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CryptoRequest {
    @JsonProperty("account_name")
    private String accountName;
    private int pos;
    private int offset;
    private String filter;
    private String sort;
    private String after;
    private String before;
    private int parent;

    public static CryptoRequest createSimpleRequest() {
        CryptoRequest cryptoRequest = new CryptoRequest();
        cryptoRequest.setAccountName("simpleassets");
        cryptoRequest.setPos(-1);
        cryptoRequest.setOffset(-100);
        return cryptoRequest;
    }
}
