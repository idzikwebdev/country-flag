package io.idzikwebdev.countryflag.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/v1/flags")
@RequiredArgsConstructor
public class CountryFlagController {

    private final RestTemplate restTemplate;


    @GetMapping(value = "/{name}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<?> getCountryFlag(@PathVariable String name) throws IOException {
        byte[] imageBytes = restTemplate.getForObject(String.format("https://countryflagsapi.com/png/%s", name), byte[].class);
        return new ResponseEntity<>(imageBytes, HttpStatus.OK);
    }
}
