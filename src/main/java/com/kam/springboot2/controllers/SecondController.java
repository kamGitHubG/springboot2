package com.kam.springboot2.controllers;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecondController {

    @GetMapping("/secondController")
    public ResponseEntity<String> getSecondController()
    {
        return ResponseEntity.of(Optional.of("Hello Second Service - second controller"));
    }
}
