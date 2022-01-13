package com.alef.webclientrickandmortyapi.controllers;

import com.alef.webclientrickandmortyapi.client.RickAndMortyLocationClient;
import com.alef.webclientrickandmortyapi.responses.ListOfLocationsResponse;
import com.alef.webclientrickandmortyapi.responses.LocationResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class RickAndMortyLocationController {

    @Autowired
    private RickAndMortyLocationClient rickAndMortyLocationClient;

    @GetMapping(path = "/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyLocationClient.getLocationById(id);
    }

    @GetMapping(path = "/locations")
    public Flux<ListOfLocationsResponse> listAllLocations() {
        return rickAndMortyLocationClient.listAllLocations();
    }
}
