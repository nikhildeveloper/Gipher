package com.app.gif.apicall.services;

import org.springframework.web.client.RestTemplate;

import com.app.gif.apicall.Domains.Gif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GifServiceImpl implements GifService {
private RestTemplate restTemplate;
@Value("${api.key}")
private String apiKey;

public GifServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    }
public Gif getGif(String query) {
    return restTemplate.getForObject("https://api.giphy.com/v1/gifs/search?api_key={apiKey}&q={query}&limit=50", Gif.class, apiKey, query);
    }   
public Gif gettrendinggifs() {
    return restTemplate.getForObject("https://api.giphy.com/v1/gifs/trending?api_key={apiKey}&limit=50", Gif.class, apiKey);
    }
}


