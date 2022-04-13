package nl.roykersten.my_trading_bot_backend.service;

import nl.roykersten.my_trading_bot_backend.model.Data;
import nl.roykersten.my_trading_bot_backend.model.LatestCryptoData;
import nl.roykersten.my_trading_bot_backend.repository.CallCryptoCurrencyApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CallCryptoApiServiceImpl implements CallCryptoApiService {

    private CallCryptoCurrencyApiRepository callCryptoCurrencyApiRepository;

    private WebClient.Builder webClientBuilder;
    private LatestCryptoData latestNo;
    private Data data;

    @Autowired
    public CallCryptoApiServiceImpl(CallCryptoCurrencyApiRepository callCryptoCurrencyApiRepository, WebClient.Builder webClientBuilder) {
        this.callCryptoCurrencyApiRepository = callCryptoCurrencyApiRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public long addCryptoCurrency() {

        //Try Catch toevoegen !!!!!!!
        List<LatestCryptoData> latestCryptoDataList = webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/cryptocurrency/listings/latest")
//                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .bodyToFlux(LatestCryptoData.class)
                .collectList()
                .block();

        int latestUpdateNo = latestCryptoDataList.size() - 1;
        int dataSize = latestCryptoDataList.get(0).getData().size();

        callCryptoCurrencyApiRepository.saveAll(latestCryptoDataList);

        return latestCryptoDataList.get(latestUpdateNo).getIdLatestCryptoData();

    }
}

