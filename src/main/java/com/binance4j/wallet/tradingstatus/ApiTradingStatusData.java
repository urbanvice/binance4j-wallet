package com.binance4j.wallet.tradingstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The API trading status detail */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiTradingStatusData {
    /**
     * @return API trading function is locked or not
     * @param isLocked The new value
     */
    private Boolean isLocked;
    /**
     * @return If API trading function is locked, this is the planned recover time
     * @param plannedRecoverTime The new value
     */
    private Long plannedRecoverTime;
    /**
     * @return The details update timestamps
     * @param updateTime The new value
     */
    private Long updateTime;
    /**
     * @return Trigger condition
     * @param triggerCondition The new value
     */
    private ApiTradingStatusTriggerCondition triggerCondition;
}