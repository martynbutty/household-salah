package com.martynbutty.householdsalah.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 * Model POJO to hold the Jamaat salah times for a given day.
 * We use a custom deserializer to extract the required fields from the JSON response from the external API. This is
 * because the returned JSON does not directly map to a simple POJO.
 * Could have used a @JsonAnySetter annotated method instead as alternative to this approach
 * See https://www.baeldung.com/jackson-deserialization for ref
 */
@Data
@JsonDeserialize(using = DaySalahJamaatDeserializer.class)
public class DaySalahJamaatTimes {
    String salahDate;
    String fajr;
    String zuhr;
    String asr;
    String maghrib;
    String isha;
    String jummah1;

    public DaySalahJamaatTimes(String date, String fajr, String zuhr,String asr, String maghrib, String isha, String jummah1) {
        setSalahDate(date);
        setFajr(fajr);
        setZuhr(zuhr);
        setAsr(asr);
        setMaghrib(maghrib);
        setIsha(isha);
        setJummah1(jummah1);
    }
}
