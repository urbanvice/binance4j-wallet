package com.binance4j.wallet.dust;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustLogUserAssetDribblets {
    /**
     * @return The operation timestamp
     * @param operateTime The new value
     */
    private Long operateTime;
    /**
     * @return The volume of asset converted
     * @param totalTransferedAmount The new value
     */
    private BigDecimal totalTransferedAmount;
    /**
     * @return The fees
     * @param totalServiceChargeAmount The new value
     */
    private BigDecimal totalServiceChargeAmount;
    /**
     * @return The transaction id
     * @param transId The new value
     */
    private Long transId;
    /**
     * @return ???
     * @param userAssetDribbletDetails The new value
     */
    private List<DustLogUserAssetDribbletDetails> userAssetDribbletDetails;
}