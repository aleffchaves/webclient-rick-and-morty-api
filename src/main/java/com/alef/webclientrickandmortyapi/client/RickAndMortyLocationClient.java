package com.alef.webclientrickandmortyapi.client;

import com.alef.webclientrickandmortyapi.responses.ListOfLocationsResponse;
import com.alef.webclientrickandmortyapi.responses.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RickAndMortyLocationClient {

    private final WebClient webClient;

    public RickAndMortyLocationClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api/").build();
    }

    public Mono<LocationResponse> getLocationById(String id) {
        return webClient.get()
                .uri("/location/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("location not found")))
                .bodyToMono(LocationResponse.class);
    }

    public Flux<ListOfLocationsResponse> listAllLocations() {
        return webClient.get()
                .uri("/location")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("fail list all locations")))
                .bodyToFlux(ListOfLocationsResponse.class);
    }
}
