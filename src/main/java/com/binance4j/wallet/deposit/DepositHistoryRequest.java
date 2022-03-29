package com.binance4j.wallet.deposit;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get a coin deposit history
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DepositHistoryRequest extends IntervalRequest {
    /**
     * @return The deposited coin
     * @param coin The new value
     */
    private String coin;
    /**
     * @return The deposit status. 0(0:pending,6: credited but cannot withdraw,
     *         1:success)
     * 
     * @param status The new value
     */
    private int status;

    /**
     * @return The history offset
     * @param offset The new value
     */
    private int offset;
    /**
     * @return The history size. Default:1000, Max:1000
     * @param limit The new value
     */
    private int limit = 1000;

    /** Default constructor */
    public DepositHistoryRequest() {
        super(1);
    }
}
