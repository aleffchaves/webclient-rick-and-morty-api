package com.alef.webclientrickandmortyapi.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocationResponse {
    private String id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
}
