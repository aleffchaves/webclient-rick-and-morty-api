package com.alef.webclientrickandmortyapi.controller;

import com.alef.webclientrickandmortyapi.client.RickAndMortyClient;
import com.alef.webclientrickandmortyapi.response.CharacterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/webclient")
public class RickAndMortyController {

    private RickAndMortyClient rickAndMortyClient;

    @GetMapping("/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findCharacterById(id);
    }
}
