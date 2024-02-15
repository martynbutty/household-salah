package com.martynbutty.householdsalah.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martynbutty.householdsalah.models.DaySalahJamaatTimes;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class MasjidAlController {
    private RestTemplate restTemplate;

    private HttpHeaders headers;

    public MasjidAlController() throws JsonProcessingException {
//        WebClient client = WebClient.builder()
//                .baseUrl("https://masjidal.com/api/v1/time/range?masjid_id=OMA5QnAr")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();

        this.restTemplate = new RestTemplate();

        String url = "https://masjidal.com/api/v1/time/range?masjid_id=OMA5QnAr";
        String responseJson = restTemplate.getForObject(url, String.class);


        DaySalahJamaatTimes daySalahJamaatTimes = new ObjectMapper().readValue(responseJson, DaySalahJamaatTimes.class);

        System.out.println("Date of prayer times: " + daySalahJamaatTimes.getSalahDate());
        System.out.println(daySalahJamaatTimes.toString());
        System.out.println("response JSON : " + responseJson);

    }
}
