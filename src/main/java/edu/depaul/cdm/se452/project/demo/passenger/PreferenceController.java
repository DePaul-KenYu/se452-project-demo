package edu.depaul.cdm.se452.project.demo.passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/preference")
@Tag(name = "Preference", description = "Everything about your Passenger Preference")
@Log4j2
public class PreferenceController {
    @Autowired
    private PreferenceService service;

    @GetMapping
    @Operation(summary = "Returns all the Passenger Preference in the database")
    @ApiResponse(responseCode = "200", description = "valid response", 
        content = {@Content(mediaType="application/json", schema=@Schema(implementation=Passenger.class))})
    public List<Preference> list() {
        return service.list();
    }

    @PostMapping
    @Operation(summary = "Save the Passenger and returns the Passenger id")
    public String save(Preference preferernce) {
        log.traceEntry("enter save", preferernce);
        service.save(preferernce);
        log.traceExit("exit save", preferernce);        
        return preferernce.getId();
    }

    @DeleteMapping
    @Operation(summary = "Delete the Passenger Preference")
    public void delete(String id) {
        log.traceEntry("Enter delete", id);
        service.delete(id);
        log.traceExit("Exit delete");
    }    
    
}
