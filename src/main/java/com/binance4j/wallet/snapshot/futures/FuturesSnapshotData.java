package com.binance4j.wallet.snapshot.futures;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** The account snapshot data */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesSnapshotData {
    /**
     * @return The assets balances
     * @param assets The new value
     */
    List<FuturesSnapshotDataAssets> assets;
    /**
     * @return ???
     * @param position The new value
     */
    List<FuturesAccountSnapshotPosition> position;
}