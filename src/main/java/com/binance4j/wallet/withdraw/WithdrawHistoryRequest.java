package com.binance4j.wallet.withdraw;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to fetch the user withdraw history */
@Data
@EqualsAndHashCode(callSuper = true)
public class WithdrawHistoryRequest extends IntervalRequest {
    /**
     * @return The coin we want the history
     * @param coin
     */
    private String coin;
    /**
     * @return The withdraw order id to fetch
     * @param withdrawOrderId
     */
    private String withdrawOrderId;
    /**
     * @return The status to look for
     * @param status
     */
    private Integer status;
    /**
     * @return The offset
     * @param offset
     */
    private Integer offset;
    /** Default:1000, Max:1000 */
    private int limit = 1000;

    /**
     * Constructor
     */
    public WithdrawHistoryRequest() {
        super(1);
    }

    /**
     * Constructor
     * 
     * @param status The withdraw status
     */
    public void setStatus(WithdrawStatus status) {
        this.status = status.getValue();
    }
}
