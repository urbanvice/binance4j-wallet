package com.binance4j.wallet.transfer;

import java.math.BigDecimal;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to operate an asset transfer between two accounts */
@Data
@EqualsAndHashCode(callSuper = true)
public class WalletTransferRequest extends FramedRequest {
    /**
     * @return
     * @param asset The new value
     */
    private String asset;
    /**
     * @return
     * @param type The new value
     */
    private WalletTransferType type;
    /**
     * @return
     * @param amount The new value
     */
    private BigDecimal amount;
    /**
     * @return must be sent when type are ISOLATEDMARGIN_MARGIN and
     *         ISOLATEDMARGIN_ISOLATEDMARGIN
     * @param fromSymbol The new value
     */
    private String fromSymbol;
    /**
     * @return must be sent when type are ISOLATEDMARGIN_MARGIN and
     *         ISOLATEDMARGIN_ISOLATEDMARGIN
     * @param toSymbol The new value
     */
    private String toSymbol;

    /**
     * Constructor
     * 
     * @param type   The transfer type
     * @param asset  The asset to transfer
     * @param amount The volume to transfer
     */
    public WalletTransferRequest(WalletTransferType type, String asset, BigDecimal amount) {
        super(1);
        this.type = type;
        this.asset = asset;
        this.amount = amount;
    }
}