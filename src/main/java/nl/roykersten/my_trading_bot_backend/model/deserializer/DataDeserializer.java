package nl.roykersten.my_trading_bot_backend.model.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import nl.roykersten.my_trading_bot_backend.model.DataModel;

import java.io.IOException;

public class DataDeserializer extends StdDeserializer<DataModel> {

    public DataDeserializer() {
        this(null);
    }

    public DataDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DataModel deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode dataModelNode = jsonParser.getCodec().readTree(jsonParser);
        DataModel dataModel = new DataModel();
        dataModel.setIdOfficial(dataModelNode.get("id").asLong());
        dataModel.setName(dataModelNode.get("name").asText());
        dataModel.setCryptoSymbol(dataModelNode.get("symbol").asText());
        dataModel.setSlug(dataModelNode.get("slug").asText());
        dataModel.setCmcRank(dataModelNode.get("cmc_rank").asText());
        dataModel.setCurrencyName(dataModelNode.get("quote").fields().next().getKey());
        dataModel.setPrice(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("price").decimalValue());

        //Check if JsonNode volume_24h is available or Null
        JsonNode validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("volume_24h"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setVolume24Hours(0.0d);
        } else {
            dataModel.setVolume24Hours(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("volume_24h").asDouble());
        }

        //Check if JsonNode percent_change_1h is available or Null
        validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_1h"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setPercentChange1Hours(0.0d);
        } else {
            dataModel.setPercentChange1Hours(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_1h").asDouble());
        }

        //Check if JsonNode percent_change_24h is available or Null
        validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_24h"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setPercentChange24Hours(0.0d);
        } else {
            dataModel.setPercentChange24Hours(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_24h").asDouble());
        }

        //Check if JsonNode percent_change_7d is available or Null
        validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_7d"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setPercentChange7Days(0.0d);
        } else {
            dataModel.setPercentChange7Days(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_7d").asDouble());
        }

        //Check if JsonNode percent_change_30d is available or Null
        validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_30d"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setPercentChange30Days(0.0d);
        } else {
            dataModel.setPercentChange30Days(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_30d").asDouble());
        }

        //Check if JsonNode percent_change_60d is available or Null
        validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_60d"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setPercentChange60Days(0.0d);
        } else {
            dataModel.setPercentChange60Days(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_60d").asDouble());
        }

        //Check if JsonNode percent_change_90d is available or Null
        validateNode = (dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_90d"));
        if (validateNode == null || validateNode.isNull()) {
            dataModel.setPercentChange90Days(0.0d);
        } else {
            dataModel.setPercentChange90Days(dataModelNode.get("quote").get(dataModelNode.get("quote").fields().next().getKey()).get("percent_change_90d").asDouble());
        }
        return dataModel;
    }

}

