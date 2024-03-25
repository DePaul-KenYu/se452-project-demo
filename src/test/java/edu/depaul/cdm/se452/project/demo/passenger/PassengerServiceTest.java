package edu.depaul.cdm.se452.project.demo.passenger;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PassengerServiceTest {
    @Autowired
    private PassengerRepository repo;

    @Autowired
    private MockMvc mvc;

    private static final String URL = "/api/passengers";

    @Test
    public void getAllAirports() throws Exception {
		// when - action
		ResultActions response = mvc.perform(MockMvcRequestBuilders.get(URL));


		var recordCount = (int) repo.count();
		
		// then - verify the output
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(recordCount)));
    }


}