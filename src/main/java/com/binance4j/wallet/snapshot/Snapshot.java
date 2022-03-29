package com.binance4j.wallet.snapshot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * A daily account snapshot
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Snapshot {
    /**
     * @return The snapshot type ("spot/margin/futures")
     * @param type The new value
     */
    private String type;
    /**
     * @return The snapshot update timestamp
     * @param updateTime The new value
     */
    private Long updateTime;
}