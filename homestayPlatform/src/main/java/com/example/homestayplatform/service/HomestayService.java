package com.example.homestayplatform.service;

import com.example.homestayplatform.model.Homestay;
import com.example.homestayplatform.repository.HomestayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;

@Service
public class HomestayService {

    @Autowired
    private HomestayRepository homestayRepository;

    public List<Homestay> getHomestaysByLocation(String location) {
        return homestayRepository.findByLocation(location);
    }

    public List<Homestay> getHomestaysByHost(Long hostId) {
        return homestayRepository.findByHostId(hostId);
    }
    
    public List<Homestay> getAllHomestays(){
    	return homestayRepository.findAll();
    }

    // Add a new homestay
    public Homestay addHomestay(String location, String name, String description, double price, Long hostId, String companyLogo, String roomPhoto1, String roomPhoto2) {
        Homestay homestay = new Homestay();
        homestay.setLocation(location);
        homestay.setName(name);
        homestay.setDescription(description);
        homestay.setPrice(price);
        homestay.setHostId(hostId);
        homestay.setCompanyLogo(companyLogo);
        homestay.setRoomPhoto1(roomPhoto1);
        homestay.setRoomPhoto2(roomPhoto2);
        return homestayRepository.save(homestay);
    }

    // Get a specific homestay by ID
    public Homestay getHomestayById(Long homestayId) {
        return homestayRepository.findById(homestayId)
                .orElseThrow(() -> new IllegalArgumentException("Homestay not found"));
    }
    
    public Homestay saveHomestay(Homestay homestay) {
        return homestayRepository.save(homestay); // Save the homestay to the database
    }
    
    public Homestay updateHomestay(long id, Homestay updatedHomestay) {
    	if(!homestayRepository.existsById(id)) {
    		throw new RuntimeException("Room not found with id: "+id);
    	}
    	
    	updatedHomestay.setId(id);
    	return homestayRepository.save(updatedHomestay);
    }
    
    public void deleteHomestay(Long id) {
    	if(!homestayRepository.existsById(id)) {
    		throw new RuntimeException("Room not found with ID: "+ id);
    	}
    	homestayRepository.deleteById(id);
    }
}
