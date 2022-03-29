package com.binance4j.wallet.tradefee;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** A trading pair trade fees */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeFee {
    /**
     * @return The trading pair
     * @param symbol The new value
     */
    private String symbol;
    /**
     * @return The maker fees (limit order)
     * @param makerCommission The new value
     */
    private BigDecimal makerCommission;
    /**
     * @return The taker fees (market order)
     * @param takerCommission The new value
     */
    private BigDecimal takerCommission;
}
