package com.levik.transactions.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CryptoResponse {
    @JsonProperty("last_irreversible_block")
    private String lastIrreversibleBlock;
    private List<Action> actions;

    @Data
    @NoArgsConstructor
    public static class Action {
        @JsonProperty("action_trace")
        private AccountTrace accountTrace;
        @JsonProperty("block_time")
        private LocalDateTime blockTime;

        private boolean irreversible;
    }

    @Data
    @NoArgsConstructor
    public static class AccountTrace {
        @JsonProperty("trx_id")
        private String trxId;
    }
}
