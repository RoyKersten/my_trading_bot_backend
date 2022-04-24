package nl.roykersten.my_trading_bot_backend.controller;

import nl.roykersten.my_trading_bot_backend.service.CallCryptoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@ControllerAdvice
@RequestMapping(value = "/cryptos", consumes = "application/json")
public class CallCryptoApiController {

    //Attributes
    private CallCryptoApiService callCryptoApiService;


    //Constructors
    @Autowired
    public CallCryptoApiController(CallCryptoApiService callCryptoApiService) {
        this.callCryptoApiService = callCryptoApiService;
    }

    //    Methods
    @PostMapping(value = "")
    public Mono<ResponseEntity<Object>> addCryptoCurrency(@RequestParam String convert) {
        long newId = 0;
        newId = callCryptoApiService.addCryptoCurrency(convert);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCrypto}")
                .buildAndExpand(newId).toUri();
        return Mono.just(ResponseEntity.created(location).body(location));
    }
}
