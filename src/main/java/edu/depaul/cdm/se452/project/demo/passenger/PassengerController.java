package edu.depaul.cdm.se452.project.demo.passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/passengers")
@Tag(name = "Passenger", description = "Everything about your Passenger")
@Log4j2
public class PassengerController {
    @Autowired
    private PassengerService service;

    @GetMapping
    @Operation(summary = "Returns all the Passenger in the database")
    @ApiResponse(responseCode = "200", description = "valid response", 
        content = {@Content(mediaType="application/json", schema=@Schema(implementation=Passenger.class))})
    public List<Passenger> list() {
        return service.list();
    }

    @PostMapping
    @Operation(summary = "Save the Passenger and returns the Passenger id")
    public long save(Passenger passenger) {
        log.traceEntry("enter save", passenger);
        service.save(passenger);
        log.traceExit("exit save", passenger);        
        return passenger.getId();
    }

    @PostMapping("/validated")
    @Operation(summary = "Save the Passenger and returns the Passenger id")
    public ResponseEntity<String> validatedSave(@Valid @RequestBody Passenger passenger) {
        log.traceEntry("enter save", passenger);
        service.save(passenger);
        log.traceExit("exit save", passenger);
        return ResponseEntity.ok("new id is " + passenger.getId());
    }

    @DeleteMapping
    @Operation(summary = "Delete the Passenger")
    public void delete(long id) {
        log.traceEntry("Enter delete", id);
        service.delete(id);
        log.traceExit("Exit delete");
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
}
