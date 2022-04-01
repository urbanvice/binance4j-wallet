package com.binance4j.wallet.dust;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** Logs of assets converted in BNB */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DustLog {
	/**
	 * @return Total counts of exchange
	 * @param total The new value
	 */
	private Integer total;
	/**
	 * @return ???
	 * @param userAssetDribblets The new value
	 */
	private List<DustLogUserAssetDribblets> userAssetDribblets;
}
