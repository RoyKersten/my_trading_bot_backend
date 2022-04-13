package nl.roykersten.my_trading_bot_backend.repository;

import nl.roykersten.my_trading_bot_backend.model.LatestCryptoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallCryptoCurrencyApiRepository extends JpaRepository<LatestCryptoData, Long> {

    //Methods
    LatestCryptoData findById(long idCrypto);
//    CryptoCurrency save(CryptoCurrency);

}
