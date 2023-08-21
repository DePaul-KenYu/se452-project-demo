package edu.depaul.cdm.se452.project.demo.flight;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    @Id
    private String code;
    private String city;
    private String state;    
}
