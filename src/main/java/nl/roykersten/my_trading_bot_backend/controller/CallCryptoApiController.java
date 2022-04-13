package nl.roykersten.my_trading_bot_backend.controller;

import nl.roykersten.my_trading_bot_backend.service.CallCryptoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public ResponseEntity<Object> addCryptoCurrency() {
        long newId = callCryptoApiService.addCryptoCurrency();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCrypto}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).body(location);
    }
}
