package com.binance4j.wallet.deposit;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** A deposit history */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositHistory {
	/**
	 * @return The volume to deposit
	 * @param amount The new value
	 */
	private BigDecimal amount;
	/**
	 * @return The coin abbreviation
	 * @param coin The new value
	 */
	private String coin;
	/**
	 * @return The transfer network
	 * @param network The new value
	 */
	private String network;
	/**
	 * @return The deposit address
	 * @param address The new value
	 */
	private String address;
	/**
	 * @return The deposit address tag
	 * @param addressTag The new value
	 */
	private String addressTag;
	/**
	 * @return The transaction id
	 * @param txId The new value
	 */
	private String txId;
	/**
	 * @return confirm times for unlocking
	 * @param unlockConfirm The new value
	 */
	private String unlockConfirm;
	/**
	 * @return ???
	 * @param confirmTimes The new value
	 */
	private String confirmTimes;
	/**
	 * @return The withdraw status
	 * @param status The new value
	 */
	private Integer status;
	/**
	 * @return confirm times for insertion (?)
	 * @param insertTime The new value
	 */
	private Long insertTime;
	/**
	 * @return The transfer type. 1 for internal transfer, 0 for external transfer
	 * @param transferType The new value
	 */
	private Integer transferType;
}
