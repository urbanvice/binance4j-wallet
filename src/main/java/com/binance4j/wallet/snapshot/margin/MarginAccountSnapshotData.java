package com.binance4j.wallet.snapshot.margin;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAccountSnapshotData {
    /**
     * @return ???
     * @param marginLevel The new value
     */
    private BigDecimal marginLevel;
    /**
     * @return ???
     * @param totalAssetOfBtc The new value
     */
    private BigDecimal totalAssetOfBtc;
    /**
     * @return ???
     * @param totalLiabilityOfBtc The new value
     */
    private BigDecimal totalLiabilityOfBtc;
    /**
     * @return ???
     * @param totalNetAssetOfBtc The new value
     */
    private BigDecimal totalNetAssetOfBtc;
    /**
     * @return ???
     * @param userAssets The new value
     */
    private List<MarginAccountSnapshotUserAssets> userAssets;
}