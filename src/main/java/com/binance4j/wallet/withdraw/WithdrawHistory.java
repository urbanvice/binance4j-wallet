package com.binance4j.wallet.withdraw;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The withdraw history */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WithdrawHistory {
	/**
	 * @return The address to withdraw to
	 * @param address The new value
	 */
	private String address;
	/**
	 * @return The the withdraw date operation
	 * @param applyTime The new value
	 */
	private String applyTime;
	/**
	 * @return The coin to withdraw
	 * @param coin The new value
	 */
	private String coin;
	/**
	 * @return The withdraw id
	 * @param id The new value
	 */
	private String id;
	/**
	 * @return will not be returned if there's no withdrawOrderId for this withdraw.
	 * @param withdrawOrderId The new value
	 */
	private String withdrawOrderId;
	/**
	 * @return The network to withdraw on
	 * @param network The new value
	 */
	private String network;
	/**
	 * @return The reason for withdrawal failure
	 * @param info The new value
	 */
	private String info;
	/**
	 * @return The transaction id
	 * @param txId The new value
	 */
	private String txId;
	/**
	 * @return 1 for internal transfer, 0 for external transfer
	 * @param transferType The new value
	 */
	private Integer transferType;
	/**
	 * @return 0(0:Email Sent,1:Cancelled 2:Awaiting Approval 3:Rejected
	 *         4:Processing 5:Failure 6:Completed)
	 * @param status The new value
	 */
	private Integer status;
	/**
	 * @return Confirm times for withdraw
	 * @param confirmNo The new value
	 */
	private Integer confirmNo;
	/**
	 * @return The withdrawn colume
	 * @param amount The new value
	 */
	private BigDecimal amount;
	/**
	 * @return The withdraw fees
	 * @param transactionFee The new value
	 */
	private BigDecimal transactionFee;
}