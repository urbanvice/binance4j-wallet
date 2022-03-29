package com.binance4j.wallet.dust;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Dust log details */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustLogUserAssetDribbletDetails {
    /**
     * @return The transaction id
     * @param transId The new value
     */
    private Long transId;
    /**
     * @return The timestamp
     * @param operateTime The new value
     */
    private Long operateTime;
    /**
     * @return The fees
     * @param serviceChargeAmount The new value
     */
    private BigDecimal serviceChargeAmount;
    /**
     * @return The volume
     * @param amount The new value
     */
    private BigDecimal amount;
    /**
     * @return The transfered amount
     * 
     * @param transferedAmount The new value
     */
    private BigDecimal transferedAmount;
    /**
     * @return The transfered asset
     * @param fromAsset The new value
     */
    private String fromAsset;
}