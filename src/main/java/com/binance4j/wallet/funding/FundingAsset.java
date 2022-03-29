package com.binance4j.wallet.funding;

import java.math.BigDecimal;

import lombok.Data;

/**
 * The Funding Wallet balance reflects a user's total crypto balance from P2P
 * buy/sell orders, Binance Payment, Binance Card and Crypto Deposit/Withdrawal
 */
@Data
public class FundingAsset {
    /**
     * @return The asset abbreviation
     * @param asset The new value
     */
    private String asset;
    /**
     * @return The available balancve
     * @param free The new value
     */
    private BigDecimal free;
    /**
     * @return The locked balance (volume in the order book)
     * @param locked The new value
     */
    private BigDecimal locked;
    /**
     * @return The freezed balance. Locked by binance (?)
     * @param freeze The new value
     */
    private BigDecimal freeze;
    /**
     * @return The pending volume withdrawing
     * @param withdrawing The new value
     */
    private BigDecimal withdrawing;
    /**
     * @return The value of the balance in BTC
     * @param btcValuation The new value
     */
    private BigDecimal btcValuation;
}