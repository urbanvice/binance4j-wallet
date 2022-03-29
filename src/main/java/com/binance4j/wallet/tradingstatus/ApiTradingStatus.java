package com.binance4j.wallet.tradingstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The authenticated account api trading status detail. */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiTradingStatus {
	/**
	 * @return The trading status data
	 * @param data The new value
	 */
	private ApiTradingStatusData data;
}