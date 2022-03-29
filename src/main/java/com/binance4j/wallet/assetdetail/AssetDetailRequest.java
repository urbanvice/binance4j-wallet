package com.binance4j.wallet.assetdetail;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get details about a supported asset */
@Data
@EqualsAndHashCode(callSuper = true)
public class AssetDetailRequest extends FramedRequest {
    /**
     * @return The asset abbreviation
     * @param asset The new value
     */
    private String asset;

    /** Constructor */
    public AssetDetailRequest() {
        super(1);
    }
}
