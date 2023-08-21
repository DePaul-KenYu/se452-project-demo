package edu.depaul.cdm.se452.project.demo.passenger;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PreferenceRepository extends MongoRepository<Preference, String> {    
    
}
