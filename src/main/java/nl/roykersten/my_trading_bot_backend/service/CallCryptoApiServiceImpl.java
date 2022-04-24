package nl.roykersten.my_trading_bot_backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.roykersten.my_trading_bot_backend.model.DataModel;
import nl.roykersten.my_trading_bot_backend.repository.CallCryptoCurrencyApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class CallCryptoApiServiceImpl implements CallCryptoApiService {

    private CallCryptoCurrencyApiRepository callCryptoCurrencyApiRepository;

    private WebClient.Builder webClientBuilder;


    @Autowired
    public CallCryptoApiServiceImpl(CallCryptoCurrencyApiRepository callCryptoCurrencyApiRepository, WebClient.Builder webClientBuilder) {
        this.callCryptoCurrencyApiRepository = callCryptoCurrencyApiRepository;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public long addCryptoCurrency(String convert) {

        //Try Catch toevoegen !!!!!!!
        List<Map> json = webClientBuilder.build()               // List of type Map ensures we can access the nested object by key like "data" or "status"
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/cryptocurrency/listings/latest")
                        .queryParam("convert", convert)                         //parameter convert ensures EUR values are returned instead of USD
                        .build())
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();


        Object data = json.get(0).get("data");
        ObjectMapper objectMapper = new ObjectMapper();
        //TypeReference is an abstract class of Jackson, It is used with object mapper to give a reference of what type of data you want after the parsing is complete, in this case List<DataModel>.
        //<>Diamond operator takes the type from the assignment operator, {} Anonymous Class
        //@JsonDeserialize is used at DataModel class level to specify custom deserializer to unmarshall the json object.
        List<DataModel> dataModel = objectMapper.convertValue(data, new TypeReference<>() {
        });

        callCryptoCurrencyApiRepository.saveAll(dataModel);

        return dataModel.size();


    }
}

