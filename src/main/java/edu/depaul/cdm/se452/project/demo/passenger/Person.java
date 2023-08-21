package edu.depaul.cdm.se452.project.demo.passenger;

import jakarta.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Person {
    private String firstName;
    private String lastName;    
}
