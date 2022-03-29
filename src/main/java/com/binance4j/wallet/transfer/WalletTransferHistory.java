package com.binance4j.wallet.transfer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The transfers wrapper */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletTransferHistory {
    /**
     * @return The list of transfers
     * @param rows The new value
     */
    private List<WalletTransfer> rows;
    /**
     * @return The result size
     * @param total The new value
     */
    private Long total;
}