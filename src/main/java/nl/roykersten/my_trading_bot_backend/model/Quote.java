package nl.roykersten.my_trading_bot_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "quote")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuote;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("USD")
    private USD USD;

    public Quote() {
    }

    public Long getIdQuote() {
        return idQuote;
    }

    public void setIdQuote(Long idQuote) {
        this.idQuote = idQuote;
    }

    public nl.roykersten.my_trading_bot_backend.model.USD getUSD() {
        return USD;
    }

    public void setUSD(nl.roykersten.my_trading_bot_backend.model.USD USD) {
        this.USD = USD;
    }
}
