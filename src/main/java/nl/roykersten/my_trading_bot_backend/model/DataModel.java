package nl.roykersten.my_trading_bot_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nl.roykersten.my_trading_bot_backend.model.deserializer.DataDeserializer;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "data_model")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = DataDeserializer.class)  //Automatic registration Deserializer when DataModel is instantiated
public class DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLatestCryptoData;

    @Column(name = "id_official")
    @JsonProperty("id")
    private long idOfficial;

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
    private String cmcRank;

    @Column(name = "currencyName")
    @JsonProperty("?")
    private String currencyName;

    @Column(name = "price")
    @JsonProperty("price")
    @Value("0")
    private BigDecimal price;

    @Column(name = "volume_24h")
    @JsonProperty("volume_24h")
    private double volume24Hours;

    @Column(name = "percent_change_1h")
    @JsonProperty("percent_change_1h")
    private double percentChange1Hours;

    @Column(name = "percent_change_24h")
    @JsonProperty("percent_change_24h")
    private double percentChange24Hours;

    @Column(name = "percent_change_7d")
    @JsonProperty("percent_change_7d")
    private double percentChange7Days;

    @Column(name = "percent_change_30d")
    @JsonProperty("percent_change_30d")

    private double percentChange30Days;

    @Column(name = "percent_change_60d")
    @JsonProperty("percent_change_60d")
    private double percentChange60Days;

    @Column(name = "percent_change_90d")
    @JsonProperty("percent_change_90d")
    private double percentChange90Days;


    public DataModel() {
    }

    public DataModel(Long idLatestCryptoData, long idOfficial, String name, String cryptoSymbol, String slug, String cmcRank, String currencyName, BigDecimal price, double volume24Hours, double percentChange1Hours, double percentChange24Hours, double percentChange7Days, double percentChange30Days, double percentChange60Days, double percentChange90Days) {
        this.idLatestCryptoData = idLatestCryptoData;
        this.idOfficial = idOfficial;
        this.name = name;
        this.cryptoSymbol = cryptoSymbol;
        this.slug = slug;
        this.cmcRank = cmcRank;
        this.currencyName = currencyName;
        this.price = price;
        this.volume24Hours = volume24Hours;
        this.percentChange1Hours = percentChange1Hours;
        this.percentChange24Hours = percentChange24Hours;
        this.percentChange7Days = percentChange7Days;
        this.percentChange30Days = percentChange30Days;
        this.percentChange60Days = percentChange60Days;
        this.percentChange90Days = percentChange90Days;
    }

    public Long getIdLatestCryptoData() {
        return idLatestCryptoData;
    }

    public void setIdLatestCryptoData(Long idLatestCryptoData) {
        this.idLatestCryptoData = idLatestCryptoData;
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

    public String getCmcRank() {
        return cmcRank;
    }

    public void setCmcRank(String cmcRank) {
        this.cmcRank = cmcRank;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public long getIdOfficial() {
        return idOfficial;
    }

    public void setIdOfficial(long idOfficial) {
        this.idOfficial = idOfficial;
    }

    public double getVolume24Hours() {
        return volume24Hours;
    }

    public void setVolume24Hours(double volume24Hours) {
        this.volume24Hours = volume24Hours;
    }

    public double getPercentChange1Hours() {
        return percentChange1Hours;
    }

    public void setPercentChange1Hours(double percentChange1Hours) {
        this.percentChange1Hours = percentChange1Hours;
    }

    public double getPercentChange24Hours() {
        return percentChange24Hours;
    }

    public void setPercentChange24Hours(double percentChange24Hours) {
        this.percentChange24Hours = percentChange24Hours;
    }

    public double getPercentChange7Days() {
        return percentChange7Days;
    }

    public void setPercentChange7Days(double percentChange7Days) {
        this.percentChange7Days = percentChange7Days;
    }

    public double getPercentChange30Days() {
        return percentChange30Days;
    }

    public void setPercentChange30Days(double percentChange30Days) {
        this.percentChange30Days = percentChange30Days;
    }

    public double getPercentChange60Days() {
        return percentChange60Days;
    }

    public void setPercentChange60Days(double percentChange60Days) {
        this.percentChange60Days = percentChange60Days;
    }

    public double getPercentChange90Days() {
        return percentChange90Days;
    }

    public void setPercentChange90Days(double percentChange90Days) {
        this.percentChange90Days = percentChange90Days;
    }
}
