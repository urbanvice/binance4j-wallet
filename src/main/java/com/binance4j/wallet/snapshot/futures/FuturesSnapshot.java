package com.binance4j.wallet.snapshot.futures;

import com.binance4j.wallet.snapshot.Snapshot;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A daily FUTURES account snapshot
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
public class FuturesSnapshot extends Snapshot {
    /**
     * @return The account snapshot data
     * @param data The new value
     */
    private FuturesSnapshotData data;
}