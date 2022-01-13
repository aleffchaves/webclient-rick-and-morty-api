package com.alef.webclientrickandmortyapi.controllers;

import com.alef.webclientrickandmortyapi.client.RickAndMortyCharacterClient;
import com.alef.webclientrickandmortyapi.responses.CharacterResponse;
import com.alef.webclientrickandmortyapi.responses.ListOfCharacterResponse;
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
public class RickAndMortyCharacterController {

    @Autowired
    private RickAndMortyCharacterClient rickAndMortyCharacterClient;

    @GetMapping(path = "/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyCharacterClient.getCharacterById(id);
    }

    @GetMapping(path = "/characters")
    public Flux<ListOfCharacterResponse> listAllCharacters() {
        return rickAndMortyCharacterClient.listAllCharacters();
    }
}
