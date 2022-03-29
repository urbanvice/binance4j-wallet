package com.binance4j.wallet.permissions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The API key permissions */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiPermissions {
    /**
     * @return is the key restricted to an ip address?
     * @param ipRestrict The new value
     */
    private Boolean ipRestrict;
    /**
     * @return This option allows you to withdraw via API. You must apply the IP
     *         Access Restriction filter in order to enable withdrawals
     * @param enableWithdrawals The new value
     */
    private Boolean enableWithdrawals;
    /**
     * @return This option authorizes this key to transfer funds between your master
     *         account and your sub account instantly
     * @param enableInternalTransfer The new value
     */
    private Boolean enableInternalTransfer;
    /**
     * @return Authorizes this key to be used for a dedicated universal transfer API
     *         to transfer multiple supported currencies. Each business's own
     *         transfer API rights are not affected by this authorization
     * @param permitsUniversalTransfer The new value
     */
    private Boolean permitsUniversalTransfer;
    /**
     * @return Authorizes this key to Vanilla options trading
     * @param enableVanillaOptions The new value
     */
    private Boolean enableVanillaOptions;
    /**
     * @return Does the key enables reading ?
     * @param enableReading The new value
     */
    private Boolean enableReading;
    /**
     * @return API Key created before your futures account opened does not support
     *         futures API service
     * @param enableFutures The new value
     */
    private Boolean enableFutures;
    /**
     * @return This option can be adjusted after the Cross Margin account transfer
     *         is completed
     * @param enableMargin The new value
     */
    private Boolean enableMargin;
    /**
     * @return Spot and margin trading
     * @param enableSpotAndMarginTrading The new value
     */
    private Boolean enableSpotAndMarginTrading;
    /**
     * @return The API key creation timestamp
     * @param createTime The new value
     */
    private Long createTime;
    /**
     * @return Expiration time for spot and margin trading permission
     * @param tradingAuthorityExpirationTime The new value
     */
    private Long tradingAuthorityExpirationTime;
}