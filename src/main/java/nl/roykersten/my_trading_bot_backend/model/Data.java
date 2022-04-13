package nl.roykersten.my_trading_bot_backend.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {


    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idData;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "crypto_symbol")
    @JsonProperty("symbol")
    private String cryptoSymbol;

    @Column(name = "slug")
    @JsonProperty("slug")
    private String slug;

    @Column(name = "cmc_rank")
    @JsonProperty("cmc_rank")
    private int cmcRank;

    @OneToOne (cascade = CascadeType.ALL)
    @JsonProperty("quote")
    private Quote quote;

    @ManyToOne
    @Transient
    private LatestCryptoData latestCryptoData;

    //constructors
    public Data() {
    }

    public Data(Long idData, String name, String cryptoSymbol, String slug, int cmcRank, LatestCryptoData latestCryptoData) {
        this.idData = idData;
        this.name = name;
        this.cryptoSymbol = cryptoSymbol;
        this.slug = slug;
        this.cmcRank = cmcRank;
        this.latestCryptoData = latestCryptoData;
    }

    //Getters and Setters
    public Long getIdData() {
        return idData;
    }

    public void setIdData(Long idData) {
        this.idData = idData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCryptoSymbol() {
        return cryptoSymbol;
    }

    public void setCryptoSymbol(String cryptoSymbol) {
        this.cryptoSymbol = cryptoSymbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getCmcRank() {
        return cmcRank;
    }

    public void setCmcRank(int cmcRank) {
        this.cmcRank = cmcRank;
    }

    public LatestCryptoData getLatestCryptoData() {
        return latestCryptoData;
    }

    public void setLatestCryptoData(LatestCryptoData latestCryptoData) {
        this.latestCryptoData = latestCryptoData;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}

