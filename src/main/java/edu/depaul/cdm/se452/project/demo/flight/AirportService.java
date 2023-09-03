package edu.depaul.cdm.se452.project.demo.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AirportService {
    @Autowired
    private AirportRepository repo;

    public List<Airport> list() {
        log.traceEntry("Enter list");
        var retval = repo.findAll();
        log.traceExit("Exit list", retval);        
        return repo.findAll();
    }

    public void save(Airport Airport) {
        log.traceEntry("enter save", Airport);
        repo.save(Airport);
        log.traceExit("exit save", Airport);                
    }


    public void delete(String code) {
        log.traceEntry("Enter delete", code);
        repo.deleteById(code);
        log.traceExit("Exit delete");
    }
}