package com.martynbutty.householdsalah.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martynbutty.householdsalah.models.DaySalahJamaatTimes;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MasjidAlController {

    private HttpHeaders headers;

    public MasjidAlController() throws JsonProcessingException {
        // Create a WebClient using its `create` factory method. Set base URL so can use relative URLS later
        WebClient client = WebClient.create("https://masjidal.com/api/v1");
        Mono<String> webClientJsonMono = client.get()
                .uri("/time/range?masjid_id=OMA5QnAr")
                .retrieve()
                .bodyToMono(String.class);

        webClientJsonMono.subscribe(resp -> {
            try {
                this.readJsonResponse(resp);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void readJsonResponse(String jsonResponse) throws JsonProcessingException {
        DaySalahJamaatTimes daySalahJamaatTimes = new ObjectMapper().readValue(jsonResponse, DaySalahJamaatTimes.class);

        System.out.println("Date of prayer times: " + daySalahJamaatTimes.getSalahDate());
        System.out.println(daySalahJamaatTimes.toString());
        System.out.println("response JSON : " + jsonResponse);

    }
}
