package com.martynbutty.householdsalah.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class DaySalahJamaatDeserializer extends StdDeserializer<DaySalahJamaatTimes> {

    public DaySalahJamaatDeserializer() {
        this(null);
    }

    public DaySalahJamaatDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DaySalahJamaatTimes deserialize(JsonParser jp, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        /*
         * path is data -> iqamah -> date, but the iqamah element is an object wrapped in an array so have to
         * get first element of that array. Would there every be a case for a second set of iqamah times???
         */
        JsonNode iqamahNode = node.get("data").get("iqamah").get(0);

        String date = (iqamahNode.get("date").asText());
        String fajr = (iqamahNode.get("fajr").asText());
        String zuhr = (iqamahNode.get("zuhr").asText());
        String asr = (iqamahNode.get("asr").asText());
        String maghrib = (iqamahNode.get("maghrib").asText());
        String isha = (iqamahNode.get("isha").asText());
        String jummah1 = (iqamahNode.get("jummah1").asText());

        return new DaySalahJamaatTimes(date, fajr, zuhr,asr, maghrib, isha, jummah1);
    }
}
