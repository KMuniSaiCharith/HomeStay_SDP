package com.example.homestayplatform.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalAttractionService {

    // For simplicity, we return a static list. In a real-world application, you can fetch this from a database or an API.
    public List<String> getLocalAttractions(String location) {
        // Example static attractions for different locations
        if (location.equalsIgnoreCase("New York")) {
            return List.of("Statue of Liberty", "Central Park", "Empire State Building");
        } else if (location.equalsIgnoreCase("Paris")) {
            return List.of("Eiffel Tower", "Louvre Museum", "Notre-Dame Cathedral");
        } else {
            return List.of("Local Park", "Museum", "Historical Landmark");
        }
    }
}
