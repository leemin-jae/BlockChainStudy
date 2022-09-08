package com.example.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class FundRaising extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506040516106d13803806106d183398181016040528101906100329190610207565b856003600001819055508460036001018190555083600360020181905550826003800160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600360040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600360050181905550505050505050610294565b600080fd5b6000819050919050565b61018681610173565b811461019157600080fd5b50565b6000815190506101a38161017d565b92915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006101d4826101a9565b9050919050565b6101e4816101c9565b81146101ef57600080fd5b50565b600081519050610201816101db565b92915050565b60008060008060008060c087890312156102245761022361016e565b5b600061023289828a01610194565b965050602061024389828a01610194565b955050604061025489828a01610194565b945050606061026589828a016101f2565b935050608061027689828a016101f2565b92505060a061028789828a01610194565b9150509295509295509295565b61042e806102a36000396000f3fe6080604052600436106100345760003560e01c80636950ae6214610039578063bd95ad0a14610076578063d0e30db0146100a1575b600080fd5b34801561004557600080fd5b50610060600480360381019061005b91906102bb565b6100bf565b60405161006d9190610303565b60405180910390f35b34801561008257600080fd5b5061008b610165565b6040516100989190610303565b60405180910390f35b6100a96101f5565b6040516100b69190610303565b60405180910390f35b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461011b57600080fd5b81600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060019050919050565b6000600360050154421015801561017c5750600047115b61018557600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc479081150290604051600060405180830381858888f193505050501580156101ed573d6000803e3d6000fd5b506001905090565b600060036002015460036001015461020d9190610357565b341461021857600080fd5b7f81e0a0a9401f56109ea65cc9c8540f79ba753fd1fafe94aa353bb8d01b9980e634336040516102499291906103cf565b60405180910390a16001905090565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006102888261025d565b9050919050565b6102988161027d565b81146102a357600080fd5b50565b6000813590506102b58161028f565b92915050565b6000602082840312156102d1576102d0610258565b5b60006102df848285016102a6565b91505092915050565b60008115159050919050565b6102fd816102e8565b82525050565b600060208201905061031860008301846102f4565b92915050565b6000819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006103628261031e565b915061036d8361031e565b9250817fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff04831182151516156103a6576103a5610328565b5b828202905092915050565b6103ba8161031e565b82525050565b6103c98161027d565b82525050565b60006040820190506103e460008301856103b1565b6103f160208301846103c0565b939250505056fea26469706673582212203cce653414449740220d754f99ef229702e55e0b9bb08e13a2047e84763658ea64736f6c63430008100033";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_SELLCONTRACT = "sellcontract";

    public static final String FUNC_GETPAID = "getpaid";

    public static final Event DEPOSITEV_EVENT = new Event("DepositEv", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected FundRaising(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected FundRaising(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected FundRaising(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected FundRaising(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<DepositEvEventResponse> getDepositEvEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSITEV_EVENT, transactionReceipt);
        ArrayList<DepositEvEventResponse> responses = new ArrayList<DepositEvEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositEvEventResponse typedResponse = new DepositEvEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEvEventResponse> depositEvEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DepositEvEventResponse>() {
            @Override
            public DepositEvEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSITEV_EVENT, log);
                DepositEvEventResponse typedResponse = new DepositEvEventResponse();
                typedResponse.log = log;
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEvEventResponse> depositEvEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSITEV_EVENT));
        return depositEvEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sellcontract(String newhedger) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SELLCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newhedger)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getpaid() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETPAID, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static FundRaising load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FundRaising(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static FundRaising load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FundRaising(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static FundRaising load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new FundRaising(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FundRaising load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new FundRaising(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<FundRaising> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger assetID, BigInteger Quantity, BigInteger price, String seller, String buyer, BigInteger date) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetID), 
                new org.web3j.abi.datatypes.generated.Uint256(Quantity), 
                new org.web3j.abi.datatypes.generated.Uint256(price), 
                new org.web3j.abi.datatypes.Address(seller), 
                new org.web3j.abi.datatypes.Address(buyer), 
                new org.web3j.abi.datatypes.generated.Uint256(date)));
        return deployRemoteCall(FundRaising.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<FundRaising> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger assetID, BigInteger Quantity, BigInteger price, String seller, String buyer, BigInteger date) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetID), 
                new org.web3j.abi.datatypes.generated.Uint256(Quantity), 
                new org.web3j.abi.datatypes.generated.Uint256(price), 
                new org.web3j.abi.datatypes.Address(seller), 
                new org.web3j.abi.datatypes.Address(buyer), 
                new org.web3j.abi.datatypes.generated.Uint256(date)));
        return deployRemoteCall(FundRaising.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FundRaising> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger assetID, BigInteger Quantity, BigInteger price, String seller, String buyer, BigInteger date) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetID), 
                new org.web3j.abi.datatypes.generated.Uint256(Quantity), 
                new org.web3j.abi.datatypes.generated.Uint256(price), 
                new org.web3j.abi.datatypes.Address(seller), 
                new org.web3j.abi.datatypes.Address(buyer), 
                new org.web3j.abi.datatypes.generated.Uint256(date)));
        return deployRemoteCall(FundRaising.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FundRaising> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger assetID, BigInteger Quantity, BigInteger price, String seller, String buyer, BigInteger date) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assetID), 
                new org.web3j.abi.datatypes.generated.Uint256(Quantity), 
                new org.web3j.abi.datatypes.generated.Uint256(price), 
                new org.web3j.abi.datatypes.Address(seller), 
                new org.web3j.abi.datatypes.Address(buyer), 
                new org.web3j.abi.datatypes.generated.Uint256(date)));
        return deployRemoteCall(FundRaising.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class DepositEvEventResponse extends BaseEventResponse {
        public BigInteger amount;

        public String sender;
    }
}
