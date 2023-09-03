package edu.depaul.cdm.se452.project.demo.passenger;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PreferenceService {
    @Autowired
    private PreferenceRepository repo;

    public List<Preference> list() {
        log.traceEntry("Enter list");
        var retval = repo.findAll();
        log.traceExit("Exit list", retval);        
        return repo.findAll();
    }

    public String save(Preference preferernce) {
        log.traceEntry("enter save", preferernce);
        repo.save(preferernce);
        log.traceExit("exit save", preferernce);        
        return preferernce.getId();
    }

    public void delete(String id) {
        log.traceEntry("Enter delete", id);
        repo.deleteById(id);
        log.traceExit("Exit delete");
    }    
   
}
