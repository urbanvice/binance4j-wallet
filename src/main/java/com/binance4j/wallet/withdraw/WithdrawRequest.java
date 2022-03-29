package com.binance4j.wallet.withdraw;

import java.math.BigDecimal;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to operate a withdraw */
@Data
@EqualsAndHashCode(callSuper = true)
public class WithdrawRequest extends FramedRequest {
    /**
     * @return The coin to withdraw
     * @param coin The new value
     */
    private String coin;
    /**
     * @return Client id for withdraw
     * @param withdrawOrderId The new value
     */
    private String withdrawOrderId;
    /**
     * @return The network to use
     * @param network The new value
     */
    private String network;
    /**
     * @return The destination address
     * @param address The new value
     */
    private String address;
    /**
     * @return Secondary address identifier for coins like XRP,XMR etc.
     * @param addressTag The new value
     */
    private String addressTag;
    /**
     * @return The volume
     * @param amount The new value
     */
    private BigDecimal amount;
    /**
     * @return When making internal transfer, true for returning the fee to the
     *         destination account; false for returning the fee back to the
     *         departure account. Default false.
     * @param transactionFeeFlag The new value
     */
    private Boolean transactionFeeFlag;
    /**
     * @return Description of the address. Space in name should be encoded into %20.
     * @param name The new value
     */
    private String name;
    /**
     * @return The wallet type for withdraw
     * @param walletType The new value
     */
    private int walletType;

    /**
     * Constructor
     * 
     * @param coin    The coin to withdraw
     * @param address The destination address
     * @param amount  The volume to withdraw
     */
    public WithdrawRequest(String coin, String address, BigDecimal amount) {
        super(1);
        this.coin = coin;
        this.address = address;
        this.amount = amount;
    }

    /**
     * @param type The wallet type to withdraw to
     */
    public void setWalletType(WalletType type) {
        walletType = type.getValue();
    }
}
