package com.example.homestayplatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Homestay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String location;
    private String name;
    private String description;
    private double price;

    private String companyLogo; // URL for the company logo
    private String roomPhoto1;  // URL for room photo 1
    private String roomPhoto2;  // URL for room photo 2
    private Long hostId; 

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getRoomPhoto1() {
		return roomPhoto1;
	}

	public void setRoomPhoto1(String roomPhoto1) {
		this.roomPhoto1 = roomPhoto1;
	}

	public String getRoomPhoto2() {
		return roomPhoto2;
	}

	public void setRoomPhoto2(String roomPhoto2) {
		this.roomPhoto2 = roomPhoto2;
	}
}
