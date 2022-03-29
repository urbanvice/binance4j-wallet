package com.binance4j.wallet.tradingstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiTradingStatusTriggerCondition {
    /**
     * @return Number of GTC orders
     * @param GCR The new value
     */
    private Long GCR;
    /**
     * @return Number of FOK/IOC orders
     * @param IFER The new value
     */
    private Long IFER;
    /**
     * @return Number of FOK/IOC orders
     * @param UFR The new value
     */
    private Long UFR;
}
