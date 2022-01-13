package com.alef.webclientrickandmortyapi;

import com.alef.webclientrickandmortyapi.responses.CharacterResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebclientRickAndMortyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientRickAndMortyApiApplication.class, args);
	}
}
