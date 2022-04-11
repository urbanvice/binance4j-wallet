# binance4j-wallet

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-wallet/badge.svg)](https://search.maven.org/search?q=com.binance4j)
[![Sonatype Nexus](https://img.shields.io/nexus/r/com.binance4j/binance4j-wallet?server=https%3A%2F%2Fs01.oss.sonatype.org%2F)](https://s01.oss.sonatype.org/#nexus-search;quick~com.binance4j)
![Build Status develop](https://img.shields.io/github/workflow/status/binance4j/binance4j-wallet/Deploy%20Artifact%20on%20Maven%20then%20merge%20on%20main/deploy?label=Test)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![JDK](https://upload.wikimedia.org/wikipedia/commons/7/75/Blue_JDK_1.8%2B_Shield_Badge.svg)

Binance4j-wallet is a Java library providing an API for interacting with the Binance wallet endpoints.

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-wallet</artifactId>
  <version>1.1.3</version>
</dependency>
```

## Usage

### Instantiate the client

```java
WalletClient client = new WalletClient(apiKy, apiSecret, useTestnet);
```

### Fetch the system status

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en#system-status-system)

```java
//sync
try{
  SystemStatus status = client.getSystemStatus().execute();
}catch(ApiNotReachedException e){ //404 error after trying to reach every server
    //...
}catch(FirewallException e){ //Web Application Firewall has been violated (HTTP 403)
    //...
}catch(RateLimitBreakException e){ //Request rate limit has been exceeded. (HTTP 429)
    //...
}catch(RateLimitBanException e){ //Account is banned for rate limit excess repetition (HTTP 418)
    //...
}catch(InternalErrorException e){ // internal error (HTTP 500)
    //...
}catch(ApiException e){ // Any error
    //...
}


//async

client.getSystemStatus().then(response->{
  //...
});

//or more specifically

client.getSystemStatus().then(new ApiCallback<SystemStatus>() {
  // HTTP 200
  @Override
  public void onResponse(SystemStatus response) {
      //...
  }

  // internal error (HTTP 500)
  @Override
  public void onInternalError() {
      //...
  } 


  //Request rate limit has been exceeded. (HTTP 429)
  @Override
  public void onRateLimitBreak() {
    //...
  }

  //Account is banned for rate limit excess repetition (HTTP 418)
  @Override
  public void onRateLimitBan() {
      //...
  }

  //Web Application Firewall has been violated (HTTP 403)
  @Override
  public void onWAFLimit() {
      //...
  }

// Any other HTTP code
  @Override
  public void onFailure(ApiException exception) {
      //...
  }
```

Next examples will only show the sync calls, the methods remain the same for every request.

### Gets information of coins (available for deposit and withdraw) for user.

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#all-coins-39-information-user_data)

```java
List<CoinInformation> infos = client.getAllCoinsInfo().execute();
```

### Fetch the daily SPOT account snapshots

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data)

```java
SpotAccountSnapshotResponse snapshot = client.getSpotAccountSnapshot().execute();
```

### Fetch the daily MARGIN account snapshots

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data)

```java
MarginAccountSnapshotResponse snapshot = client.getMarginAccountSnapshot().execute();
```

### 

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#daily-account-snapshot-user_data)

```java
FuturesAccountSnapshotResponse snapshot = client.getFuturesAccountSnapshot().execute();
```

### Disable fast withdraw switch under your account

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#disable-fast-withdraw-switch-user_data)

```java
client.disableFastWithdrawSwitch(new FastWithdrawSwitchRequest()).execute();
```

### Enable fast withdraw switch under your account

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#enable-fast-withdraw-switch-user_data)

```java
client.enableFastWithdrawSwitch(new FastWithdrawSwitchRequest()).execute();
```

### Submit a withdraw request

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#withdraw-user_data)

```java
WithdrawRequest req = new WithdrawRequest(symbol, address, amount);
WithdrawResult res = client.withdraw(req).execute();
```

### Fetch the deposit history of one or multiple coins

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#deposit-history-supporting-network-user_data)

```java
List<DepositHistory> history = client.getDepositHistory().execute();
```

### Fetch the withdraw history of all coins

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#withdraw-history-supporting-network-user_data)

```java
List<WithdrawHistory> history = client.getWithdrawHistory().execute();
```

### Fetch deposit address

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#deposit-address-supporting-network-user_data)

```java
DepositAddressRequest req = new DepositAddressRequest("BTC")
DepositAddress address = client.getDepositAddress(req).execute();
```

### Fetch the account status detail

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#deposit-address-supporting-network-user_data)

```java
AccountStatus status = client.getAccountstatus().execute();
```

### Fetch the account api trading status detail

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#account-api-trading-status-user_data)

```java
ApiTradingStatus status = client.getApiTradingStatus().execute();
```

### Fetch the dust tranfer logs

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#dustlog-user_data)

```java
DustLog log = client.getDustLog(new DustLogRequest()).execute();
```

### Convert dust assets to BNB

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#dust-transfer-user_data)

```java
DustTransferRequest req = new DustTransferRequest(assets);
DustTransferResponse res = client.dustTransfert(req).execute();
```

### Fetch the API Key Permission

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#get-api-key-permission-user_data)

```java
ApiPermissions permissions = client.getApiPermissions().execute();
```

### Fetch the dividend record of all assets

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#asset-dividend-record-user_data)

```java
AssetDividendRecord record = client.getAssetDividendRecord().execute();
```

### Fetch the details of an asset supported on Binance

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#asset-detail-user_data)

```java
Map<String, AssetDetail> details = client.getAssetDetail().execute();
```

### Fetch the funding wallet asset balance

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#query-user-universal-transfer-history-user_data)

```java
List<FundingAsset> fundings = client.getFundingAsset().execute();
```

### Fetch the trade fee

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#trade-fee-user_data)

```java
List<TradeFee> fees = client.getTradeFee().execute();
```

### Fetch the user universal transfer history

[Binance Documentation](https://binance-docs.github.io/apidocs/spot/en/#query-user-universal-transfer-history-user_data)

```java
WalletTransferHistoryRequest req = new WalletTransferHistoryRequest(WalletTransferType.MAIN_FUNDING);
WalletTransferHistory history = client.getTransferHistory(req).execute();
```

[Javadoc](https://binance4j.github.io/binance4j-wallet/)
