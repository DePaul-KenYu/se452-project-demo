package edu.depaul.cdm.se452.project.demo.passenger;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PassengerService {
    @Autowired
    private PassengerRepository repo;

    public List<Passenger> list() {
        log.traceEntry("Enter list");
        var retval = repo.findAll();
        log.traceExit("Exit list", retval);        
        return repo.findAll();
    }

    public Passenger save(Passenger passenger) {
        log.traceEntry("enter save", passenger);
        repo.save(passenger);
        log.traceExit("exit save", passenger);        
        return passenger;
    }

   public void delete(long id) {
        log.traceEntry("Enter delete", id);
        repo.deleteById(id);
        log.traceExit("Exit delete");
    }    
}