package com.alef.webclientrickandmortyapi.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListOfCharacterResponse {
    private List<CharacterResponse> results;
}
