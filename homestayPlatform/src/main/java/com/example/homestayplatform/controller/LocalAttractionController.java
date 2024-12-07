package com.example.homestayplatform.controller;

import com.example.homestayplatform.service.LocalAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
public class LocalAttractionController {

    @Autowired
    private LocalAttractionService localAttractionService;

    // Get local attractions by location
    @GetMapping("/{location}")
    public ResponseEntity<List<String>> getLocalAttractions(@PathVariable String location) {
        List<String> attractions = localAttractionService.getLocalAttractions(location);
        return ResponseEntity.ok(attractions);
    }
}
