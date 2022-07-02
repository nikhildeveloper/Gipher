package com.app.gif.apicall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gif.apicall.Domains.Gif;
import com.app.gif.apicall.services.GifService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// localhost:8021/gif/trending
@RestController
@RequestMapping("/gif")
public class GifController {
    @Autowired
    private GifService gifService;
    public GifController(GifService gifService) {
        this.gifService = gifService;
    }

    @GetMapping("/{query}")
    public ResponseEntity<Gif> getGif(@PathVariable String query) {
        Gif gif = gifService.getGif(query);
        return ResponseEntity.ok(gif);
    }
    @GetMapping("/trending")
    public ResponseEntity<Gif> getTrendingGifs() {
        Gif gif = gifService.gettrendinggifs();
        return ResponseEntity.ok(gif);
    }    
}
