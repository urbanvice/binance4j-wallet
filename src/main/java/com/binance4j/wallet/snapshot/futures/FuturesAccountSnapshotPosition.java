package com.binance4j.wallet.snapshot.futures;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesAccountSnapshotPosition {
    /**
     * @return The asset pair
     * @param symbol The new value
     */
    private String symbol;
    /**
     * @return The entry price
     * @param entryPrice The new value
     */
    private BigDecimal entryPrice;
    /**
     * @return ???
     * @param markPrice The new value
     */
    private BigDecimal markPrice;
    /**
     * @return The position amount
     * @param positionAmt The new value
     */
    private BigDecimal positionAmt;
    /**
     * @return Only show the value at the time of opening the position
     * @param unRealizedProfit The new value
     */
    private BigDecimal unRealizedProfit;
}