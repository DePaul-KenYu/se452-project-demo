package edu.depaul.cdm.se452.project.demo.passenger;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document
public class Preference {
    enum SeatLocation {
        AISLE, 
        MIDDLE,   
        WINDOW    
    }
    
    @Id
    private String id;
    private Map<String, String> frequentMileageTracker;
    private SeatLocation seatLocation;
}


