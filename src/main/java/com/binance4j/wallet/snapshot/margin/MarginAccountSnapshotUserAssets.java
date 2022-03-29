package com.binance4j.wallet.snapshot.margin;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAccountSnapshotUserAssets {
    /**
     * @return The asset abbreviation
     * @param asset The new value
     **/
    private String asset;
    /**
     * @return The borrowed amount
     * @param borrowed The new value
     **/
    private BigDecimal borrowed;
    /**
     * @return The fee amount
     * @param free The new value
     **/
    private BigDecimal free;
    /**
     * @return The interest amount
     * @param interest The new value
     **/
    private BigDecimal interest;
    /**
     * @return The locked volume
     * @param locked The new value
     **/
    private BigDecimal locked;
    /**
     * @return ???
     * @param netAsset The new value
     **/
    private BigDecimal netAsset;
}