package com.binance4j.wallet.snapshot;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get a list of SPOT, MARGIN or FUTURES daily account snapshots
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountSnapshotRequest extends IntervalRequest {
    /**
     * @return The snapshot limit. min 5, max 30, default 5
     * @param limit The new value
     */
    private int limit = 5;

    /** Constructor */
    public AccountSnapshotRequest() {
        super(2400);
    }
}
