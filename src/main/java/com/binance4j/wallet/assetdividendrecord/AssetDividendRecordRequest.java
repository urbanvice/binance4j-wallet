package com.binance4j.wallet.assetdividendrecord;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get a list of asset dividends */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetDividendRecordRequest extends IntervalRequest {
    /**
     * @return The asset abbreviation
     * @param asset The new value
     */
    private String asset;
    /**
     * @return The result limi. Default 20, max 500
     * @param limit The new value
     */
    private int limit = 20;

    /** Constructor */
    public AssetDividendRecordRequest() {
        super(10);
    }
}
