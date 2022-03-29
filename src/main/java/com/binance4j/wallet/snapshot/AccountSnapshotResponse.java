package com.binance4j.wallet.snapshot;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * The base of an account snapshot response
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AccountSnapshotResponse<T> {
    /**
     * @return The response status code (200 for success; others are error
     *         codes)
     * @param code The new value
     */
    private int code;
    /**
     * @return The potential response error message
     * @param msg The new value
     */
    private String msg;
    /**
     * @return A list of account snapshots
     * @param snapshotVos The new value
     */
    private List<T> snapshotVos;
}
