package com.binance4j.wallet.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

/**
 * Status of a submitted order.
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransferType {
  SPOT_TO_MARGIN("1"), MARGIN_TO_SPOT("2");

  private String value;

  public String getValue() {
    return value;
  }
}
