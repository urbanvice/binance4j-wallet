package com.binance4j.wallet.assetdividendrecord;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** An asset divident */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDividend {
    /**
     * @return The divident amount
     * @param amount The new amount value
     */
    private BigDecimal amount;
    /**
     * @return ???
     * @param enInfo The enInfo new value
     */
    private String enInfo;
    /**
     * @return The asset abbreviation
     * @param asset The asset new value
     */
    private String asset;
    /**
     * @return
     * @param id The new value
     */
    private Long id;
    /**
     * @return
     * @param divTime The new value
     */
    private Long divTime;
    /**
     * @return
     * @param tranId The new value
     */
    private Long tranId;
}