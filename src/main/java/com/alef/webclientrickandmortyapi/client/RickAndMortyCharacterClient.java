package com.alef.webclientrickandmortyapi.client;

import com.alef.webclientrickandmortyapi.responses.CharacterResponse;
import com.alef.webclientrickandmortyapi.responses.ListOfCharacterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyCharacterClient {

    private final WebClient webClient;

    public RickAndMortyCharacterClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api/").build();
    }

    public Mono<CharacterResponse> getCharacterById(String id) {
        log.info("find character by id, return a Mono of character");
        return webClient.get()
                .uri("/character/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("character not found")))
                .bodyToMono(CharacterResponse.class);
    }

    public Flux<ListOfCharacterResponse> listAllCharacters() {
        log.info(" get all characters, return a flux of characters");
        return webClient.get()
                .uri("/character")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("list of characters not found")))
                .bodyToFlux(ListOfCharacterResponse.class);
    }
}
