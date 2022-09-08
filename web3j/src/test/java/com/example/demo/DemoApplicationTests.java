package com.example.demo;

import com.example.contract.FundRaising;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class DemoApplicationTests {
    Web3j web3j = Web3j.build(new HttpService());
    @Test
    void sss() throws IOException {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();

        System.out.println("clientVersion : " + clientVersion);
    }

    @Test
    public void getEthClientVersionASync() throws Exception
    {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        System.out.println("clientVersionASync : " + web3ClientVersion.getWeb3ClientVersion());
    }

    public EthBlockNumber getBlockNumber() throws Exception{  // 현재 블록 번호
        EthBlockNumber result = new EthBlockNumber();
        result = this.web3j.ethBlockNumber()
                .sendAsync()
                .get();
        return result;
    }

    public EthAccounts getEthAccounts() throws ExecutionException, InterruptedException {
        EthAccounts result = new EthAccounts();
        result = this.web3j.ethAccounts()
                .sendAsync()
                .get();
        return result;

    }

    @Test
    public void test() throws Exception
    {
        System.out.println("계정 정보 : + "+ getEthAccounts().getAccounts());
        System.out.println("현재 블록 정보 : " + getBlockNumber().getBlockNumber());
        //새 지갑 생성
        //WalletUtils.generateNewWalletFile("1234", new File("C:\\Users\\multicampus\\Desktop\\project\\blockchain\\account"), true);
        //

        Credentials credentials = WalletUtils.loadCredentials("1234", "C:\\Users\\multicampus\\Desktop\\project\\blockchain\\account\\UTC--2022-09-07T16-38-37.430843300Z--090f91f86eb888d11609f59cd4cfcef49520e7db.json");
        //Credentials.create("개인키")

        System.out.println("credentials : " + credentials);
        System.out.println("credentials address : " + credentials.getAddress());
        // 계약 배포
        ContractGasProvider gasProvider = new DefaultGasProvider();

        FastRawTransactionManager manager = new FastRawTransactionManager( // 이게 뭐랑가
                web3j,
                credentials,
                new PollingTransactionReceiptProcessor(web3j, 3000, 3)
        );
        //FundRaising contract = FundRaising.load(credentials.getAddress(),web3j , credentials , gasProvider);;
        FundRaising contract = FundRaising.load(credentials.getAddress(),web3j , credentials , gasProvider);
    }

}
