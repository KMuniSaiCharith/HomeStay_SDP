package com.example.homestayplatform.repository;

import com.example.homestayplatform.model.Homestay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomestayRepository extends JpaRepository<Homestay, Long> {

	List<Homestay> findByLocation(String location);

    // Find homestays by host ID
    List<Homestay> findByHostId(Long hostid);

    // Find a homestay by its ID
    Optional<Homestay> findById(Long id);

    // Delete a homestay by its ID
    void deleteById(Long id);

    // Check if a homestay exists by ID
    boolean existsById(Long id);
    
    
}
