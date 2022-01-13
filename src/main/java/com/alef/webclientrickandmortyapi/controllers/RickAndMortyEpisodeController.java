package com.alef.webclientrickandmortyapi.controllers;


import com.alef.webclientrickandmortyapi.client.RickAndMortyEpisodeClient;
import com.alef.webclientrickandmortyapi.responses.EpisodeResponse;
import com.alef.webclientrickandmortyapi.responses.ListOfEpisodesResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping(path = "/webclient")
public class RickAndMortyEpisodeController {

    @Autowired
    private RickAndMortyEpisodeClient rickAndMortyEpisodeClient;

    @GetMapping(path = "/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyEpisodeClient.getEpisodeById(id);
    }

    @GetMapping(path = "/episodes")
    public Flux<ListOfEpisodesResponse> listAllEpisode() {
        return rickAndMortyEpisodeClient.listAllEpisode();
    }
}
