package com.alef.webclientrickandmortyapi.client;

import com.alef.webclientrickandmortyapi.response.CharacterResponse;
import com.alef.webclientrickandmortyapi.response.EpisodeResponse;
import com.alef.webclientrickandmortyapi.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api/").build();
    }

    public Mono<CharacterResponse> findCharacterById(String id) {
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Check the informed parameters")))
                .bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findLocationById(String id) {
        return webClient
                .get()
                .uri("/location/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Check the informed parameters")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findEpisodeById(String id) {
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Check the informed parameters")))
                .bodyToMono(EpisodeResponse.class);
    }




}
