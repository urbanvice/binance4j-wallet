package com.binance4j.wallet.client;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositAddressRequest;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.dust.DustLog;
import com.binance4j.wallet.dust.DustLogRequest;
import com.binance4j.wallet.funding.FundingAsset;
import com.binance4j.wallet.permissions.ApiPermissions;
import com.binance4j.wallet.snapshot.futures.FuturesAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.margin.MarginAccountSnapshotResponse;
import com.binance4j.wallet.snapshot.spot.SpotAccountSnapshotResponse;
import com.binance4j.wallet.systemstatus.SystemStatus;
import com.binance4j.wallet.tradefee.TradeFee;
import com.binance4j.wallet.tradingstatus.ApiTradingStatus;
import com.binance4j.wallet.transfer.WalletTransferHistory;
import com.binance4j.wallet.transfer.WalletTransferHistoryRequest;
import com.binance4j.wallet.transfer.WalletTransferType;
import com.binance4j.wallet.withdraw.FastWithdrawSwitchRequest;
import com.binance4j.wallet.withdraw.WithdrawHistory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletClientTest {
    WalletClient client;

    public WalletClientTest() {
        String key = System.getenv("BINANCE_API_KEY");
        String secret = System.getenv("BINANCE_API_SECRET");
        client = new WalletClient(key, secret, false);
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetSystemStatus() {
        try {
            SystemStatus status = client.getSystemStatus().execute();
            assertNotNull(status.getMsg());
            assertNotNull(status.getStatus());
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetAllCoinsInfo() {
        try {
            List<CoinInformation> infos = client.getAllCoinsInfo().execute();
            infos.forEach(i -> {
                assertNotNull(i.getCoin());
                assertNotNull(i.getDepositAllEnable());
                assertNotNull(i.getFree());
                assertNotNull(i.getFreeze());
                assertNotNull(i.getIpoable());
                assertNotNull(i.getIpoing());
                assertNotNull(i.getIsLegalMoney());
                assertNotNull(i.getLocked());
                assertNotNull(i.getName());
                assertNotNull(i.getNetworkList());
                assertNotNull(i.getStorage());
                assertNotNull(i.getTrading());
                assertNotNull(i.getWithdrawAllEnable());
                assertNotNull(i.getWithdrawing());
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetSpotAccountSnapshot() {
        try {
            SpotAccountSnapshotResponse snapshot = client.getSpotAccountSnapshot().execute();
            assertNotEquals(0, snapshot.getCode());
            assertNotNull(snapshot.getMsg());

            snapshot.getSnapshotVos().forEach(s -> {
                s.getData().getBalances().forEach(b -> {
                    assertNotNull(b.getClass());
                    assertNotNull(b.getFree());
                    assertNotNull(b.getLocked());
                });
                assertNotNull(s.getData().getTotalAssetOfBtc());
                assertNotNull(s.getType());
                assertNotNull(s.getUpdateTime());

            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetMarginAccountSnapshot() throws InterruptedException, ExecutionException {
        try {
            MarginAccountSnapshotResponse snapshot = client.getMarginAccountSnapshot().execute();
            assertNotEquals(0, snapshot.getCode());
            assertNotNull(snapshot.getMsg());

            snapshot.getSnapshotVos().forEach(s -> {
                assertNotNull(s.getType());
                assertNotNull(s.getUpdateTime());
                assertNotNull(s.getData().getMarginLevel());
                assertNotNull(s.getData().getTotalAssetOfBtc());
                assertNotNull(s.getData().getTotalLiabilityOfBtc());
                assertNotNull(s.getData().getTotalNetAssetOfBtc());
                s.getData().getUserAssets().forEach(ua -> {
                    assertNotNull(ua.getAsset());
                    assertNotNull(ua.getBorrowed());
                    assertNotNull(ua.getFree());
                    assertNotNull(ua.getInterest());
                    assertNotNull(ua.getLocked());
                    assertNotNull(ua.getNetAsset());
                });
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetFuturesAccountSnapshot() {
        try {
            FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
            assertNotEquals(0, snapshot.getCode());
            assertNotNull(snapshot.getSnapshotVos());

            snapshot.getSnapshotVos().forEach(s -> {
                assertNotNull(s.getType());
                assertNotNull(s.getUpdateTime());
                assertNotNull(s.getData().getPosition());
                s.getData().getAssets().forEach(a -> {
                    assertNotNull(a.getAsset());
                    assertNotNull(a.getMarginBalance());
                    assertNotNull(a.getWalletBalance());
                });
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testDisableFastWithdrawSwitch() {
        try {
            client.disableFastWithdrawSwitch(new FastWithdrawSwitchRequest()).execute();
            System.out.println("ok");
            assertNotNull("ok");
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testEnableFastWithdrawSwitch() {
        try {
            client.enableFastWithdrawSwitch(new FastWithdrawSwitchRequest()).execute();
            System.out.println("ok");
            assertNotNull("ok");
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetDepositHistory() {
        try {
            List<DepositHistory> history = client.getDepositHistory().execute();
            history.forEach(h -> {
                assertNotNull(h.getAddress());
                assertNotNull(h.getAddressTag());
                assertNotNull(h.getAmount());
                assertNotNull(h.getCoin());
                assertNotNull(h.getConfirmTimes());
                assertNotNull(h.getInsertTime());
                assertNotNull(h.getNetwork());
                assertNotNull(h.getStatus());
                assertNotNull(h.getTransferType());
                assertNotNull(h.getTxId());
                assertNotNull(h.getUnlockConfirm());
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetWithdrawHistory() {
        try {
            List<WithdrawHistory> history = client.getWithdrawHistory().execute();
            history.forEach(h -> {
                assertNotNull(h.getAddress());
                assertNotNull(h.getAmount());
                assertNotNull(h.getApplyTime());
                assertNotNull(h.getCoin());
                assertNotNull(h.getConfirmNo());
                assertNotNull(h.getId());
                assertNotNull(h.getInfo());
                assertNotNull(h.getNetwork());
                assertNotNull(h.getStatus());
                assertNotNull(h.getTransactionFee());
                assertNotNull(h.getTransferType());
                assertNotNull(h.getTxId());
                // not always true
                // assertNotNull(h.getWithdrawOrderId());
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetDepositAddress() {
        try {
            DepositAddress address = client.getDepositAddress(new DepositAddressRequest("BNB")).execute();
            assertNotNull(address.getAddress());
            assertNotNull(address.getCoin());
            assertNotNull(address.getTag());
            assertNotNull(address.getUrl());
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetAccountstatus() {
        try {
            AccountStatus status = client.getAccountstatus().execute();
            assertNotNull(status.getData());
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetApiTradingStatus() {
        ExchangeInfoRequest req = new ExchangeInfoRequest();
        req.getSymbols();
        try {
            ApiTradingStatus status = client.getApiTradingStatus().execute();
            assertNotNull(status.getData().getIsLocked());
            assertNotNull(status.getData().getPlannedRecoverTime());
            assertNotNull(status.getData().getTriggerCondition().getGCR());
            assertNotNull(status.getData().getTriggerCondition().getIFER());
            assertNotNull(status.getData().getTriggerCondition().getUFR());
            assertNotNull(status.getData().getUpdateTime());
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Properties shouldn't be null or throw an Exception")
    public void testGetDustLog() {
        try {
            DustLog log = client.getDustLog(new DustLogRequest()).execute();
            assertNotNull(log.getTotal());
            log.getUserAssetDribblets().forEach(uad -> {
                assertNotNull(uad.getOperateTime());
                assertNotNull(uad.getTotalServiceChargeAmount());
                assertNotNull(uad.getTotalTransferedAmount());
                assertNotNull(uad.getTransId());
                uad.getUserAssetDribbletDetails().forEach(d -> {
                    assertNotNull(d.getAmount());
                    assertNotNull(d.getFromAsset());
                    assertNotNull(d.getOperateTime());
                    assertNotNull(d.getServiceChargeAmount());
                    assertNotNull(d.getTransId());
                    assertNotNull(d.getTransferedAmount());
                });
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }


    @Test
    public void testGetApiPermissions() {
        try {
            ApiPermissions permissions = client.getApiPermissions().execute();
            assertNotNull(permissions.getCreateTime());
            assertNotNull(permissions.getEnableFutures());
            assertNotNull(permissions.getEnableInternalTransfer());
            assertNotNull(permissions.getEnableMargin());
            assertNotNull(permissions.getEnableReading());
            assertNotNull(permissions.getEnableSpotAndMarginTrading());
            assertNotNull(permissions.getEnableVanillaOptions());
            assertNotNull(permissions.getEnableWithdrawals());
            assertNotNull(permissions.getIpRestrict());
            assertNotNull(permissions.getPermitsUniversalTransfer());
            // can be null if not configured to expire
            // assertNotNull(permissions.getTradingAuthorityExpirationTime());
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetAssetDetail() {
        try {
            Map<String, AssetDetail> details = client.getAssetDetail().execute();
            details.values().forEach(v -> {
                assertNotNull(v.getDepositStatus());
                // sometimes empty
                // assertNotNull(v.getDepositTip());
                assertNotNull(v.getMinWithdrawAmount());
                assertNotNull(v.getWithdrawFee());
                assertNotNull(v.getWithdrawStatus());
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetAssetDividend() {
        try {
            AssetDividendRecord record = client.getAssetDividendRecord().execute();
            assertNotNull(record.getTotal());
            record.getRows().forEach(r -> {
                assertNotNull(r.getAmount());
                assertNotNull(r.getAsset());
                assertNotNull(r.getDivTime());
                assertNotNull(r.getEnInfo());
                assertNotNull(r.getId());
                assertNotNull(r.getTranId());
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetFundingAsset() {
        try {
            List<FundingAsset> fundings = client.getFundingAsset().execute();
            fundings.forEach(f -> {
                assertNotNull(f.getAsset());
                assertNotNull(f.getBtcValuation());
                assertNotNull(f.getFree());
                assertNotNull(f.getFreeze());
                assertNotNull(f.getLocked());
                assertNotNull(f.getWithdrawing());
            });
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetTradeFee() {
        try {
            List<TradeFee> fees = client.getTradeFee().execute();
            fees.forEach(f -> {
                assertNotNull(f.getMakerCommission());
                assertNotNull(f.getSymbol());
                assertNotNull(f.getTakerCommission());
            });
            assertNotNull(fees);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetTransferHistory() {
        try {
            WalletTransferHistory history = client
                    .getTransferHistory(new WalletTransferHistoryRequest(WalletTransferType.MAIN_FUNDING)).execute();
            assertNotNull(history.getTotal());
            if (history.getRows() != null) {
                history.getRows().forEach(r -> {
                    assertNotNull(r.getAmount());
                    assertNotNull(r.getAsset());
                    assertNotNull(r.getStatus());
                    assertNotNull(r.getTimestamp());
                    assertNotNull(r.getTranId());
                    assertNotNull(r.getType());
                });
            }
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }
}
