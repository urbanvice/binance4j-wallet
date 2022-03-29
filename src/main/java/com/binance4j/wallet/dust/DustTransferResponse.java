package com.binance4j.wallet.dust;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The dust transfer (asset to BNB) response */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustTransferResponse {
	/**
	 * @return The fees
	 * @param totalServiceCharge The new value
	 */
	private BigDecimal totalServiceCharge;
	/**
	 * @return The volume converted into BNB after fees
	 * @param totalTransfered The new value
	 */
	private BigDecimal totalTransfered;
	/**
	 * @return Detailed transfer result asset by asset
	 * @param transferResult The new value
	 */
	private List<DustTransferResult> transferResult;
}