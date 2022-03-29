package com.binance4j.wallet.dust;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Details about an asset dust trasnfer (convertion into BNB) */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustTransferResult {
    /**
     * @return The amount of volume converted
     * @param amount The new value
     */
    private BigDecimal amount;
    /**
     * @return The converted asset abbreviation
     * @param fromAsset The new value
     */
    private String fromAsset;
    /**
     * @return The operation timestamp
     * @param operateTime The new value
     */
    private Long operateTime;
    /**
     * @return The fees
     * @param serviceChargeAmount The new value
     */
    private BigDecimal serviceChargeAmount;
    /**
     * @return The transaction id
     * @param tranId The new value
     */
    private Long tranId;
    /**
     * @return The transfered amount after fees
     * @param transferedAmount The new value
     */
    private BigDecimal transferedAmount;
}