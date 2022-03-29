package com.binance4j.wallet.coinsinfo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * The coin network informations
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinNetworkInformation {
    /**
     * @return The address pattern
     * @param addressRegex The new value
     */
    private String addressRegex;
    /**
     * @return ?
     * @param addressRule The new value
     */
    private String addressRule;
    /**
     * @return The coin abbreviation
     * @param coin The new value
     */
    private String coin;
    /**
     * @return The deposit description
     * @param depositDesc The new value
     */
    private String depositDesc;
    /**
     * @return The withdra description
     * @param withdrawDesc The new value
     */
    private String withdrawDesc;
    /**
     * @return The network name
     * @param name The new value
     */
    private String name;
    /**
     * @return The memo pattern
     * @param memoRegex The new value
     */
    private String memoRegex;
    /**
     * @return ?
     * @param network The new value
     */
    private String network;
    /**
     * @return Tips about the network
     * @param specialTips The new value
     */
    private String specialTips;
    /**
     * @return Tips about the withdraw
     * @param specialWithdrawTips The new value
     */
    private String specialWithdrawTips;
    /**
     * @return ?
     * @param depositDust The new value
     */
    private BigDecimal depositDust;
    /**
     * @return The withdraw fee
     * @param withdrawFee The new value
     */
    private BigDecimal withdrawFee;
    /**
     * @return ?
     * @param withdrawIntegerMultiple The new value
     */
    private BigDecimal withdrawIntegerMultiple;
    /**
     * @return The maximal amount authorized to be withdrawn
     * @param withdrawMax The new value
     */
    private BigDecimal withdrawMax;
    /**
     * @return The minimal amount authorized to be withdrawn
     * @param withdrawMin The new value
     */
    private BigDecimal withdrawMin;
    /**
     * @return The min number for balance confirmation
     * @param minConfirm The new value
     */
    private int minConfirm;
    /**
     * @return The confirmation number for balance unlock
     * @param unLockConfirm The new value
     */
    private int unLockConfirm;
    /**
     * @return If deposit is enabled
     * @param depositEnable The new value
     */
    private Boolean depositEnable;
    /**
     * @return if is the default network
     * @param isDefault The new value
     */
    private Boolean isDefault;
    /**
     * @return ?
     * @param resetAddressStatus The new value
     */
    private Boolean resetAddressStatus;
    /**
     * @return If withdraw is enabled
     * @param withdrawEnable The new value
     */
    private Boolean withdrawEnable;
    /**
     * @return If the coin needs to provide memo to withdraw
     * @param sameAddress The new value
     */
    private Boolean sameAddress;
}