package com.alef.webclientrickandmortyapi.controller;

import com.alef.webclientrickandmortyapi.client.RickAndMortyClient;
import com.alef.webclientrickandmortyapi.response.CharacterResponse;
import com.alef.webclientrickandmortyapi.response.EpisodeResponse;
import com.alef.webclientrickandmortyapi.response.ListOfEpisodesResponse;
import com.alef.webclientrickandmortyapi.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/webclient")
public class RickAndMortyController {

    private RickAndMortyClient rickAndMortyClient;

    @GetMapping("/characters/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findCharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyClient.findLocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyClient.findEpisodeById(id);
    }

    @GetMapping("/episodes")
    public Flux<ListOfEpisodesResponse> listAllEpisodes() {
        return rickAndMortyClient.findAllEpisodes();
    }

}
