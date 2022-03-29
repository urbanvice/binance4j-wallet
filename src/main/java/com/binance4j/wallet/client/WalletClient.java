package com.binance4j.wallet.client;

import java.util.List;
import java.util.Map;

import com.binance4j.core.request.RequestExecutor;
import com.binance4j.core.request.RestClient;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.accountstatus.AccountStatusRequest;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdetail.AssetDetailRequest;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecordRequest;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import com.binance4j.wallet.coinsinfo.CoinInformationRequest;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositAddressRequest;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.deposit.DepositHistoryRequest;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustLogRequest;
import com.binance4j.wallet.dust.DustTransferRequest;
import com.binance4j.wallet.dust.DustTransferResponse;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.funding.FundingAssetRequest;
import com.binance4j.wallet.permissions.ApiPermissions;
import com.binance4j.wallet.permissions.ApiPermissionsRequest;
import com.binance4j.wallet.snapshot.AccountSnapshotRequest;
import com.binance4j.wallet.snapshot.AccountSnapshotType;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.spot.SpotAccountSnapshotResponse;
import com.binance4j.wallet.systemstatus.SystemStatus;
import com.binance4j.wallet.systemstatus.SystemStatusRequest;
import com.binance4j.wallet.tradefee.TradeFee;
import com.binance4j.wallet.tradefee.TradeFeeRequest;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;
import com.binance4j.wallet.tradingstatus.ApiTradingStatusRequest;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryRequest;
import com.binance4j.wallet.transfer.WalletTransferRequest;
import com.binance4j.wallet.transfer.WalletTransferResponse;
import com.binance4j.wallet.withdraw.FastWithdrawSwitchRequest;
import com.binance4j.wallet.withdraw.WithdrawHistory;
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;
import com.binance4j.wallet.withdraw.WithdrawRequest;
import com.binance4j.wallet.withdraw.WithdrawResult;

/**
 * The API client for the wallet endpoints
 */
public class WalletClient extends RestClient<WalletMapping> {

    /**
     * Instantiates a client for the wallet endpoints with the choice to use the
     * test network
     *
     * @param key        The API public key
     * @param secret     The API secret key
     * @param useTestnet Are we using TestNet?
     */
    public WalletClient(String key, String secret, Boolean useTestnet) {
        super(WalletMapping.class, key, secret, useTestnet);
    }

    /**
     * Instantiates a client for the wallet endpoints
     *
     * @param key    The API public key
     * @param secret The API secret key
     */
    public WalletClient(String key, String secret) {
        this(key, secret, false);
    }

    /**
     * Fetches the system status.
     *
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en#system-status-system">Documentation</a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<SystemStatus> getSystemStatus() {
        return new RequestExecutor<>(service.getSystemStatus(), new SystemStatusRequest());
    }

    /**
     * Gets information of coins (available for deposit and withdraw) for user.
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#all-coins-39-information-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<CoinInformation>> getAllCoinsInfo(CoinInformationRequest request) {
        return new RequestExecutor<>(service.getAllCoinsInfo(pojoToMap(request)), request);
    }

    /**
     * Gets the information of coins (available for deposit and withdraw) for user
     * with default request.
     * 
     * @see #getAllCoinsInfo(CoinInformationRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<CoinInformation>> getAllCoinsInfo() {
        return getAllCoinsInfo(new CoinInformationRequest());
    }

    /**
     * Fetches the daily SPOT account snapshots.
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<SpotAccountSnapshotResponse> getSpotAccountSnapshot(AccountSnapshotRequest request) {
        return new RequestExecutor<>(service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, pojoToMap(request)),
                request);
    }

    /**
     * Fetches the last 5 daily SPOT account snapshots with default request.
     * 
     * @see #getSpotAccountSnapshot(AccountSnapshotRequest)
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<SpotAccountSnapshotResponse> getSpotAccountSnapshot() {
        return getSpotAccountSnapshot(new AccountSnapshotRequest());
    }

    /**
     * Fetches the daily MARGIN account snapshots
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<MarginAccountSnapshotResponse> getMarginAccountSnapshot(AccountSnapshotRequest request) {
        return new RequestExecutor<>(service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, pojoToMap(request)),
                request);
    }

    /**
     * Fetches the last 5 daily MARGIN account snapshots with default request.
     * 
     * @see #getMarginAccountSnapshot(AccountSnapshotRequest)
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<MarginAccountSnapshotResponse> getMarginAccountSnapshot() {
        return getMarginAccountSnapshot(new AccountSnapshotRequest());
    }

    /**
     * Fetches the daily FUTURES account snapshots
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot(AccountSnapshotRequest request) {
        return new RequestExecutor<>(service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES,
                pojoToMap(request)), request);
    }

    /**
     * Fetches the last 5 daily FUTURES account snapshots with default request.
     * 
     * @see #getFuturesAccountSnapshot(AccountSnapshotRequest)
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<FuturesAccountSnapshotResponse> getFuturesAccountSnapshot() {
        return getFuturesAccountSnapshot(new AccountSnapshotRequest());
    }

    /**
     * Disables fast withdraw switch under your account.
     * 
     * You need to enable {@code trade} option for the api key which
     * requests this endpoint.
     * 
     * @param request The custom request
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#disable-fast-withdraw-switch-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<Void> disableFastWithdrawSwitch(FastWithdrawSwitchRequest request) {
        return new RequestExecutor<>(service.disableFastWithdrawSwitch(pojoToMap(request)), request);
    }

    /**
     * Disables fast withdraw switch under your account with default request.
     * 
     * @see #disableFastWithdrawSwitch(FastWithdrawSwitchRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<Void> disableFastWithdrawSwitch() {
        return disableFastWithdrawSwitch(new FastWithdrawSwitchRequest());
    }

    /**
     * Enables fast withdraw switch under your account.
     * <ul>
     * <li>>You need to enable "trade" option for the api key which requests
     * this endpoint.
     * </li>
     * 
     * <li>>When Fast Withdraw Switch is on, transferring funds to a Binance
     * account will be done instantly. There is no on-chain transaction, no
     * transaction ID and no withdrawal fee.
     * </li>
     * </ul>
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#enable-fast-withdraw-switch-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<Void> enableFastWithdrawSwitch(FastWithdrawSwitchRequest request) {
        return new RequestExecutor<>(service.enableFastWithdrawSwitch(pojoToMap(request)), request);
    }

    /**
     * Enables fast withdraw switch under your account with default request.
     * 
     * @see #enableFastWithdrawSwitch(FastWithdrawSwitchRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<Void> enableFastWithdrawSwitch() {
        return enableFastWithdrawSwitch(new FastWithdrawSwitchRequest());
    }

    /**
     * Submits a withdraw request.
     * 
     * If network not send, return with default network of the coin.
     * You can get {@code network</code> and <code>isDefault} in
     * networkList of a coin in the response of {@link #getAllCoinsInfo()}
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#withdraw-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<WithdrawResult> withdraw(WithdrawRequest request) {
        return new RequestExecutor<>(service.withdraw(pojoToMap(request)), request);
    }

    /**
     * Fetches the deposit history of one or multiple coins.
     * 
     * 
     * <ul>
     * <li>
     * Please notice the default {@code startTime} and
     * {@code endTime} to make sure that time interval is within 0-90
     * days.
     * </li>
     * <li>
     * If both {@code startTime</code> and <code>endTime} are sent,
     * time between {@code startTime</code> and <code>endTime} must be
     * less than 90 days.
     * </li>
     * </ul>
     * 
     * @param request The custom request
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#deposit-history-supporting-network-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<DepositHistory>> getDepositHistory(DepositHistoryRequest request) {
        return new RequestExecutor<>(service.getDepositHistory(pojoToMap(request)), request);
    }

    /**
     * Fetches the last deposit history of all coins.
     * 
     * @see #getDepositHistory(DepositHistoryRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<DepositHistory>> getDepositHistory() {
        return getDepositHistory(new DepositHistoryRequest());
    }

    /**
     * Fetches the withdraw history of one or multiple coins.
     * <ul>
     * <li>
     * network may not be in the response for old withdraw.
     * </li>
     * <li>
     * Please notice the default {@code startTime} and
     * {@code endTime} to make sure that time interval is within 0-90
     * days.
     * </li>
     * <li>
     * If both {@code startTime</code> and <code>endTime} are sent,
     *          time between {@code startTime</code> and <code>endTime}
     * must be less than 90 days.
     * </li>
     * </ul>
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#withdraw-history-supporting-network-user_data">Documentation</a>
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<List<WithdrawHistory>> getWithdrawHistory(WithdrawHistoryRequest request) {
        return new RequestExecutor<>(service.getWithdrawHistory(pojoToMap(request)), request);

    }

    /**
     * Fetches the last withdraw history of all coins.
     * 
     * @see #getWithdrawHistory(WithdrawHistoryRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<WithdrawHistory>> getWithdrawHistory() {
        return getWithdrawHistory(new WithdrawHistoryRequest());

    }

    /**
     * Fetches deposit address
     * <ul>
     * <li>
     * If {@code network} is not send, return with default network of
     * the coin.
     * </li>
     * <li>
     * You can get {@code network} and {@code isDefault} in
     * {@code networkList} in the response of
     * {@link #getAllCoinsInfo(CoinInformationRequest)}
     * </li>
     * </ul>
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#deposit-address-supporting-network-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<DepositAddress> getDepositAddress(DepositAddressRequest request) {
        return new RequestExecutor<>(service.getDepositAddress(pojoToMap(request)), request);
    }

    /**
     * Fetches the account status detail.
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#deposit-address-supporting-network-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<AccountStatus> getAccountstatus(AccountStatusRequest request) {
        return new RequestExecutor<>(service.getAccountstatus(pojoToMap(request)), request);
    }

    /**
     * Fetches the account status detail with default request.
     * 
     * @see getAccountstatus(AccountStatusRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<AccountStatus> getAccountstatus() {
        return getAccountstatus(new AccountStatusRequest());
    }

    /**
     * Fetches the account api trading status detail.
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#account-api-trading-status-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<ApiTradingStatus> getApiTradingStatus(ApiTradingStatusRequest request) {
        return new RequestExecutor<>(service.getApiTradingStatus(pojoToMap(request)), request);
    }

    /**
     * Fetches the account api trading status detail with default request.
     * 
     * @see #getApiTradingStatus(ApiTradingStatusRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<ApiTradingStatus> getApiTradingStatus() {
        return getApiTradingStatus(new ApiTradingStatusRequest());
    }

    /**
     * Fetches the dust tranfer logs
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#dustlog-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<DustLog> getDustLog(DustLogRequest request) {
        return new RequestExecutor<>(service.getDustLog(pojoToMap(request)), request);
    }

    /**
     * Fetches the dust tranfer logs with default paramters
     * 
     * @see #getDustLog(DustLogRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<DustLog> getDustLog() {
        return getDustLog(new DustLogRequest());
    }

    /**
     * Convert dust assets to BNB.
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#dust-transfer-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<DustTransferResponse> dustTransfert(DustTransferRequest request) {
        return new RequestExecutor<>(service.dustTransfert(pojoToMap(request)), request);
    }

    /**
     * Queries the dividend record of one or multiple assets.
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#asset-dividend-record-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<AssetDividendRecord> getAssetDividend(AssetDividendRecordRequest request) {
        return new RequestExecutor<>(service.getAssetDividendRecord(pojoToMap(request)), request);
    }

    /**
     * Queries the last 20 dividend asset records
     * 
     * @see #getAssetDividend(AssetDividendRecordRequest)
     * @return The executor permitting sync/async API call
     * 
     */
    public RequestExecutor<AssetDividendRecord> getAssetDividend() {
        return getAssetDividend(new AssetDividendRecordRequest());
    }

    /**
     * Fetches the details of an asset supported on Binance.
     * Please get network and other deposit or withdraw details from
     * {@link #getAllCoinsInfo()}
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#asset-detail-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<Map<String, AssetDetail>> getAssetDetail(AssetDetailRequest request) {
        return new RequestExecutor<>(service.getAssetDetail(pojoToMap(request)), request);
    }

    /**
     * Fetches the details of all assets supported on Binance
     * 
     * @see #getAssetDetail(AssetDetailRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<Map<String, AssetDetail>> getAssetDetail() {
        return getAssetDetail(new AssetDetailRequest());
    }

    /**
     * Fetches the trade fee
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#trade-fee-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<TradeFee>> getTradeFee(TradeFeeRequest request) {
        return new RequestExecutor<>(service.getTradeFee(pojoToMap(request)), request);
    }

    /**
     * Fetches the trade fee with default request
     * 
     * @see #getTradeFee(TradeFeeRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<TradeFee>> getTradeFee() {
        return getTradeFee(new TradeFeeRequest());
    }

    /**
     * Makse a universal transfer
     * <ul>
     * <li>
     * You need to enable {@code Permits Universal Transfer} option
     * for the api key which requests this endpoint.
     * </li>
     * <li>
     * fromSymbol must be sent when type are ISOLATEDMARGIN_MARGIN and
     * ISOLATEDMARGIN_ISOLATEDMARGIN
     * </li>
     * <li>
     * toSymbol must be sent when type are MARGIN_ISOLATEDMARGIN and
     * ISOLATEDMARGIN_ISOLATEDMARGIN
     * </li>
     * </ul>
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#user-universal-transfer-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<WalletTransferResponse> transfer(WalletTransferRequest request) {
        return new RequestExecutor<>(service.transfer(pojoToMap(request)), request);
    }

    /**
     * Fetches the user universal transfer history
     * <ul>
     * <li>
     * fromSymbol must be sent when type are ISOLATEDMARGIN_MARGIN and
     * ISOLATEDMARGIN_ISOLATEDMARGIN
     * </li>
     * <li>
     * toSymbol must be sent when type are MARGIN_ISOLATEDMARGIN and
     * ISOLATEDMARGIN_ISOLATEDMARGIN
     * </li>
     * <li>
     * Support query within the last 6 months only
     * </li>
     * <li>
     * If startTime and endTime not sent, return records of the last 7 days
     * by default
     * </li>
     * </ul>
     * 
     * @param request The custom request
     * 
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-user-universal-transfer-history-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<WalletTransferHistory> getTransferHistory(WalletTransferHistoryRequest request) {
        return new RequestExecutor<>(service.getTransferHistory(pojoToMap(request)), request);
    }

    /**
     * Fetches the funding wallet asset balance
     * 
     * Currently supports querying the following business assets：Binance
     * Pay, Binance Card, Binance Gift Card, Stock Token
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#query-user-universal-transfer-history-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<FundingAsset>> getFundingAsset(FundingAssetRequest request) {
        return new RequestExecutor<>(service.getFundingAsset(pojoToMap(request)), request);
    }

    /**
     * Fetches the funding wallet asset balance with default request
     * 
     * @see #getFundingAsset(FundingAssetRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<List<FundingAsset>> getFundingAsset() {
        return getFundingAsset(new FundingAssetRequest());
    }

    /**
     * Fetches the API Key Permission
     * 
     * @param request The custom request
     * @see <a href=
     *      "https://binance-docs.github.io/apidocs/spot/en/#get-api-key-permission-user_data">
     *      Documentation </a>
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<ApiPermissions> getApiPermissions(ApiPermissionsRequest request) {
        return new RequestExecutor<>(service.getApiPermissions(pojoToMap(request)), request);
    }

    /**
     * Fetches the API Key Permission with default request
     * 
     * @see #getApiPermissions(ApiPermissionsRequest)
     * @return The executor permitting sync/async API call
     */
    public RequestExecutor<ApiPermissions> getApiPermissions() {
        return getApiPermissions(new ApiPermissionsRequest());
    }
}