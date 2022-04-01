package com.binance4j.wallet.systemstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The system status */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemStatus {
	/**
	 * @return The system status code (0: normal，1：maintenance)
	 * @param status The new value
	 */
	private Integer status;
	/**
	 * @return The system status message ("normal" or "system_maintenance")
	 * @param msg The new value
	 */
	private String msg;
}