package nl.roykersten.my_trading_bot_backend.repository;

import nl.roykersten.my_trading_bot_backend.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallCryptoCurrencyApiRepository extends JpaRepository<DataModel, Long> {

    //Methods
    DataModel findById(long idLatestCryptoData);


}
