package nl.roykersten.my_trading_bot_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    public static String headerName = "X-CMC_PRO_API_KEY";

    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder()
                .baseUrl("https://sandbox-api.coinmarketcap.com")
                .defaultHeader(headerName, System.getenv("apiKey"))
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Accept-Encoding", "deflate", "gzip");
    }
}
