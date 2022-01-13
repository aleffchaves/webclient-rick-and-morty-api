package com.alef.webclientrickandmortyapi.client;

import com.alef.webclientrickandmortyapi.responses.EpisodeResponse;
import com.alef.webclientrickandmortyapi.responses.ListOfEpisodesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyEpisodeClient {
    private final WebClient webClient;

    public RickAndMortyEpisodeClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<EpisodeResponse> getEpisodeById(String id) {
        log.info("get a episode by id, return a mono of episode");
        return webClient.get()
                .uri("/episode/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("episode not found")))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodesResponse> listAllEpisode() {
        log.info("list all episodes, return a flux of episodes");
        return webClient.get()
                .uri("/episode")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("fail to list all episodes")))
                .bodyToFlux(ListOfEpisodesResponse.class);
    }
}
