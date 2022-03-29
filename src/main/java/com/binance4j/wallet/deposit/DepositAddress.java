package com.binance4j.wallet.deposit;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * A deposit address for a given asset.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositAddress {
	/**
	 * @return The deposit url
	 * @param url The new value
	 */
	private String url;
	/**
	 * @return The deposit address
	 * @param address The new value
	 */
	private String address;
	/**
	 * @return The deposit tag
	 * @param tag The new value
	 */
	private String tag;
	/**
	 * @return The coin abbreviation
	 * @param coin The new value
	 */
	private String coin;
}