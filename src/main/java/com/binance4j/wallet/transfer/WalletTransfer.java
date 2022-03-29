package com.binance4j.wallet.transfer;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** A wallet to wallet transfer */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletTransfer {
    /**
     * @return The transfered asset
     * @param asset The new value
     */
    private String asset;
    /**
     * @return The transfered amount
     * @param amount The new value
     */
    private BigDecimal amount;
    /**
     * @return The transfer type (origin wallet to destination wallet)
     * @param type The new value
     */
    private WalletTransferType type;
    /**
     * @return The transfer status
     * @param status The new value
     */
    private String status;
    /**
     * @return The transaction id
     * @param tranId The new value
     */
    private Long tranId;
    /**
     * @return The transfer timestamp
     * @param timestamp The new value
     */
    private Long timestamp;
}
