package com.binance4j.wallet.snapshot.futures;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The snapshot assets balances */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesSnapshotDataAssets {
    /**
     * @return The asset abbreviation
     * @param asset The new value
     */
    private String asset;
    /**
     * @return The margin balance
     * @param marginBalance The new value
     */
    private BigDecimal marginBalance;
    /**
     * @return The wallet balance
     * @param walletBalance The new value
     */
    private BigDecimal walletBalance;
}