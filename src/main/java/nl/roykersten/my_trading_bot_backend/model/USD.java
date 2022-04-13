package nl.roykersten.my_trading_bot_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "usd")
@JsonIgnoreProperties(ignoreUnknown = true)
public class USD {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurrency;

    @Column(name = "price")
    private double price;

    public USD() {
    }

    public Long getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(Long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
