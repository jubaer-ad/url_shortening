package com.spring_ui.springuiapp.urlshortner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Short_Controller {

    private Short_Service shortService;

    @Autowired
    public Short_Controller(Short_Service shortService) {
        this.shortService = shortService;
    }

    @GetMapping("/{shortURL}")
    public ResponseEntity<?> getShortenURL(@PathVariable String shortURL) throws URISyntaxException{
        Short controllerShort = shortService.getShort(shortURL);
        System.out.println("Main URL: " + controllerShort);
        URI uri = new URI(controllerShort.getMainURL());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/get/all")
    public List<Short> getAllShort(){
        return shortService.getAllShorts();
    }

    @GetMapping("/get/last")
    public Short getLastShorts(){
        return shortService.getLastShort();
    }

    @PostMapping("/short")
    public ResponseEntity<?> postShortenURL(@Valid @RequestBody ShortCreateRequest shortCreateRequest) {
        return ResponseEntity.ok(shortService.createShort(shortCreateRequest));

    }
    
}
