package nl.roykersten.my_trading_bot_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "latest_crypto_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestCryptoData {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLatestCryptoData;

    @JsonProperty("status")
    @OneToOne(cascade = CascadeType.ALL)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_latest_crypto_data")
    private List<Data> data;

    public LatestCryptoData() {
    }

    public LatestCryptoData(Long idLatestCryptoData, Status status, List<Data> data) {
        this.idLatestCryptoData = idLatestCryptoData;
        this.status = status;
        this.data = data;
    }

    public Long getIdLatestCryptoData() {
        return idLatestCryptoData;
    }

    public void setIdLatestCryptoData(long l) {
        this.idLatestCryptoData = idLatestCryptoData;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
