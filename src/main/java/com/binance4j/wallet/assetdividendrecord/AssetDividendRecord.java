package com.binance4j.wallet.assetdividendrecord;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** An asset divident record */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDividendRecord {
	/**
	 * @return The records
	 * @param rows The new value
	 */
	private List<AssetDividend> rows;
	/**
	 * @return The number of record
	 * @param total The new value
	 */
	private Long total;
}
