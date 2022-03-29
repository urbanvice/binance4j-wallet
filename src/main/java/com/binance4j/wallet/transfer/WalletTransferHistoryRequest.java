package com.binance4j.wallet.transfer;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** Request to fetch User Universal Transfer History */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferHistoryRequest extends IntervalRequest {
    /**
     * @return The User universal transfer type
     * @param type The new value
     */
    private WalletTransferType type;
    /**
     * @return ???
     * @param current The new value
     */
    private int current = 1;
    /**
     * @return The result size
     * @param size The new value
     */
    private int size = 10;
    /**
     * @return Must be sent when type are ISOLATEDMARGIN_MARGIN and
     *         ISOLATEDMARGIN_ISOLATEDMARGIN
     * @param fromSymbol The new value
     */
    private String fromSymbol;
    /**
     * @return Must be sent when type are MARGIN_ISOLATEDMARGIN and
     *         ISOLATEDMARGIN_ISOLATEDMARGIN
     * @param toSymbol The new value
     */
    private String toSymbol;

    /**
     * Constructor
     * 
     * @param type The transfer type
     */
    public WalletTransferHistoryRequest(WalletTransferType type) {
        super(1);
        this.type = type;
    }
}
