package com.detroitlabs.ThemePark.service;
import com.detroitlabs.ThemePark.data.AttractionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Arrays;


@Component
public class ParkService {


    public static AttractionRepository fetchAttractionData() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpsHeaders = new HttpHeaders();
        httpsHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpsHeaders.add("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36" );
        HttpEntity<String> entity = new HttpEntity<String>("parameters", httpsHeaders);
        ResponseEntity responseEntity = restTemplate.exchange("https://queue-times.com/en-US/parks/16/queue_times.json", HttpMethod.GET, entity, String.class);
        return new ObjectMapper().readValue(responseEntity.getBody().toString(), AttractionRepository.class);
    }
}
