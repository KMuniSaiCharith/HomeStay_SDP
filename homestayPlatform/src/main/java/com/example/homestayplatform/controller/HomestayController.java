package com.example.homestayplatform.controller;

import com.example.homestayplatform.model.Homestay;
import com.example.homestayplatform.service.HomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/homestays")
public class HomestayController {

    @Autowired
    private HomestayService homestayService;
    
    @GetMapping
    public ResponseEntity<List<Homestay>> getAllHomestay(){
    	List<Homestay> homestays = homestayService.getAllHomestays();
    	return ResponseEntity.ok(homestays);
    }

    // Add a new homestay
    @PostMapping
    public ResponseEntity<String> addHomestay(
            @RequestParam("location") String location,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("hostId") Long hostId,
            @RequestParam("companyLogo") String companyLogo,
            @RequestParam("roomPhoto1") String roomPhoto1,
            @RequestParam("roomPhoto2") String roomPhoto2) {

        

        try {
            Homestay addedHomestay = homestayService.addHomestay(location, name, description, price, hostId, companyLogo, roomPhoto1, roomPhoto2);
            return ResponseEntity.ok("Homestay added successfully with ID: " + addedHomestay.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add homestay: " + e.getMessage());
        }
    }


    // Get homestays by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Homestay>> getHomestaysByLocation(@PathVariable String location) {
        List<Homestay> homestays = homestayService.getHomestaysByLocation(location);
        return ResponseEntity.ok(homestays);
    }

    // Get homestays by host
    @GetMapping("/host/{hostId}")
    public ResponseEntity<List<Homestay>> getHomestaysByHost(@PathVariable Long hostId) {
        List<Homestay> homestays = homestayService.getHomestaysByHost(hostId);
        return ResponseEntity.ok(homestays);
    }

    // Get homestay by ID
    @GetMapping("/{id}")
    public ResponseEntity<Homestay> getHomestayById(@PathVariable Long id) {
        Homestay homestay = homestayService.getHomestayById(id);
        return ResponseEntity.ok(homestay);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateHomstay(
        @PathVariable("id") Long id, 
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "description", required = false) String description,
        @RequestParam(value = "price", required = false) Double price,
        @RequestParam(value = "location", required = false) String location,
        @RequestParam(value = "image", required = false) MultipartFile[] images) {

        // Fetch the existing homestay by its ID
        Homestay existingHomestay = homestayService.getHomestayById(id);
        
        if (existingHomestay == null) {
            return ResponseEntity.status(404).body("Homestay not found");
        }

        // Update only the fields that are provided in the request
        if (name != null) {
            existingHomestay.setName(name);
        }
        if (description != null) {
            existingHomestay.setDescription(description);
        }
        if (price != null) {
            existingHomestay.setPrice(price);
        }
        if (location != null) {
            existingHomestay.setLocation(location);
        }

        // Handle images if provided
        if (images != null && images.length > 0) {
            // Process images (save to disk or cloud storage)
            for (MultipartFile image : images) {
                // Save each image here
            }
        }

        // Save the updated homestay using the service
        Homestay updatedHomestay = homestayService.saveHomestay(existingHomestay);
        return ResponseEntity.ok(updatedHomestay);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHomestay(@PathVariable("id") Long id){
    	homestayService.deleteHomestay(id);
    	return ResponseEntity.noContent().build();
    }
}
