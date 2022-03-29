package com.binance4j.wallet.transfer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The user universal transfer response */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletTransferResponse {
    /**
     * @return The transaction id
     * @param tranId The new value
     */
    private Long tranId;
}