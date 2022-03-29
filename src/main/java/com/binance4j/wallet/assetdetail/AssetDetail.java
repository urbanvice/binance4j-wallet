package com.binance4j.wallet.assetdetail;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Details of a supported asset */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDetail {
    /**
     * @return The minimal withdraw amount
     * @param minWithdrawAmount The new value
     */
    private BigDecimal minWithdrawAmount;
    /**
     * @return The deposit status (false if ALL of networks' are false)
     * @param depositStatus The new value
     */
    private boolean depositStatus;
    /**
     * @return The withdraw fee
     * @param withdrawFee The new value
     */
    private float withdrawFee;
    /**
     * @return The withdraw status (false if ALL of networks' are false)
     * @param withdrawStatus The new value
     */
    private boolean withdrawStatus;
    /**
     * @return The reason of the status
     * @param depositTip The new value
     */
    private String depositTip;
}