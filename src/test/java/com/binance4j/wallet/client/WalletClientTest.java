package com.binance4j.wallet.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exchangeinfo.ExchangeInfoRequest;
import com.binance4j.wallet.accountstatus.AccountStatus;
import com.binance4j.wallet.assetdetail.AssetDetail;
import com.binance4j.wallet.assetdetail.AssetDetailRequest;
import com.binance4j.wallet.assetdividendrecord.AssetDividendRecord;
import com.binance4j.wallet.coinsinfo.CoinInformation;
import com.binance4j.wallet.deposit.DepositAddress;
import com.binance4j.wallet.deposit.DepositAddressRequest;
import com.binance4j.wallet.deposit.DepositHistory;
import com.binance4j.wallet.deposit.DepositHistoryRequest;
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
import com.binance4j.wallet.withdraw.WithdrawHistoryRequest;

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
    @DisplayName("System status should return a response or throw an Exception")
    public void testGetSystemStatus() {
        try {
            SystemStatus status = client.getSystemStatus().execute();
            System.out.println(status);
            assertNotNull(status);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Coins info should return a response or throw an Exception")
    public void testGetAllCoinsInfo() {
        try {
            List<CoinInformation> infos = client.getAllCoinsInfo().execute();
            System.out.println(infos);
            assertNotNull(infos);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Spot account snapshot should return a response or throw an Exception")
    public void testGetSpotAccountSnapshot() {
        try {
            SpotAccountSnapshotResponse snapshot = client.getSpotAccountSnapshot().execute();
            System.out.println(snapshot);
            assertNotNull(snapshot);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("Margin account snapshot should return a response or throw an Exception or throw code -3003")
    public void testGetMarginAccountSnapshot() throws InterruptedException, ExecutionException {
        try {
            MarginAccountSnapshotResponse snapshot = client.getMarginAccountSnapshot().execute();
            System.out.println(snapshot);
            assertNotNull(snapshot);
        } catch (ApiException e) {
            System.out.println(e.getError());
            assertNotNull(e);
        }

    }

    @Test
    @DisplayName("Futures account snapshot should return a response or throw an Exception")
    public void testGetFuturesAccountSnapshot() {
        try {
            FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
            System.out.println(snapshot);
            assertNotNull(snapshot);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("It should not throw an exception")
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
    @DisplayName("It should not throw an exception")
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
    @DisplayName("It should return the deposit history")
    public void testGetDepositHistory() {
        try {
            List<DepositHistory> history = client.getDepositHistory(new DepositHistoryRequest()).execute();
            System.out.println(history);
            assertNotNull(history);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("It should return the withdraw history")
    public void testGetWithdrawHistory() {
        try {
            List<WithdrawHistory> history = client.getWithdrawHistory(new WithdrawHistoryRequest()).execute();
            System.out.println(history);
            assertNotNull(history);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    @DisplayName("It should return a deposit address")
    public void testGetDepositAddress() {
        try {
            DepositAddress address = client.getDepositAddress(new DepositAddressRequest("BNB")).execute();
            System.out.println(address);
            assertNotNull(address);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetAccountstatus() {
        try {
            AccountStatus status = client.getAccountstatus().execute();
            System.out.println(status);
            assertNotNull(status);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetApiTradingStatus() {
        ExchangeInfoRequest req = new ExchangeInfoRequest();
        req.getSymbols();
        try {
            ApiTradingStatus status = client.getApiTradingStatus().execute();
            System.out.println(status);
            assertNotNull(status);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetDustLog() {
        try {
            DustLog log = client.getDustLog(new DustLogRequest()).execute();
            System.out.println(log);
            assertNotNull(log);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetApiPermissions() {
        try {
            ApiPermissions permissions = client.getApiPermissions().execute();
            System.out.println(permissions);
            assertNotNull(permissions);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetAssetDetail() {
        try {
            Map<String, AssetDetail> details = client.getAssetDetail(new AssetDetailRequest()).execute();
            System.out.println(details);
            assertNotNull(details);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetAssetDividend() {
        try {
            AssetDividendRecord record = client.getAssetDividend().execute();
            System.out.println(record);
            assertNotNull(record);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetFundingAsset() {
        try {
            List<FundingAsset> fundings = client.getFundingAsset().execute();
            System.out.println(fundings);
            assertNotNull(fundings);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }

    @Test
    public void testGetTradeFee() {
        try {
            List<TradeFee> fees = client.getTradeFee().execute();
            System.out.println(fees);
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
            System.out.println(history);
            assertNotNull(history);
        } catch (ApiException e) {
            System.out.println(e);
            assertNotNull(e);
        }
    }
}
