package com.binance4j.wallet.coinsinfo;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The coin informations for the authenticated account */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinInformation {
	/**
	 * @return The coin abbreviation
	 * @param coin The new value
	 */
	private String coin;
	/**
	 * @return The coin name
	 * @param name The new value
	 */
	private String name;
	/**
	 * @return The deposit permission
	 * @param depositAllEnable The new value
	 */
	private Boolean depositAllEnable;
	/**
	 * @return if the coin is a legal money
	 * @param isLegalMoney The new value
	 */
	private Boolean isLegalMoney;
	/**
	 * @return if the coin can be traded
	 * @param trading The new value
	 */
	private Boolean trading;
	/**
	 * @return The withdraw permission
	 * @param withdrawAllEnable The new value
	 */
	private Boolean withdrawAllEnable;
	/**
	 * @return The free balance
	 * @param free The new value
	 */
	private BigDecimal free;
	/**
	 * @return The freezed balance
	 * @param freeze The new value
	 */
	private BigDecimal freeze;
	/**
	 * @return The Initial Public Offering balance (?)
	 * @param ipoable The new value
	 */
	private BigDecimal ipoable;
	/**
	 * @return The Initial Public Offering freezed balance (?)
	 * @param ipoing The new value
	 */
	private BigDecimal ipoing;
	/**
	 * @return The locked balance
	 * @param locked The new value
	 */
	private BigDecimal locked;
	/**
	 * @return ?
	 * @param storage The new value
	 */
	private BigDecimal storage;
	/**
	 * @return The withdrawing balance
	 * @param withdrawing The new value
	 */
	private BigDecimal withdrawing;
	/**
	 * @return The coin network information
	 * @param networkList The new value
	 */
	private List<CoinNetworkInformation> networkList;
}
