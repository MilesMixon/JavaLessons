package com.skillstorm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Dinosaur;
import com.skillstorm.controller.DinosaurController;
import com.skillstorm.services.DinosaurService;

//by default will start every controller
@WebMvcTest(controllers = DinosaurController.class)
//can have scripts run before or after all of your methods
//@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"schema-mysql.sql", "data-mysql.sql"})
//@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "teardown.sql")
public class DinoControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DinosaurService service;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
//	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"schema-mysql.sql", "data-mysql.sql"})
//	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "teardown.sql")
	void findAll() throws Exception {
		//can tell it what i want the service/ db to return so i can test the controller
		List<Dinosaur> dinos = new LinkedList<>();
		dinos.add(new Dinosaur(17, "Chicken", "Green"));
		dinos.add(new Dinosaur(18, "Crocodile", "Rainbow"));
		Mockito.when(service.findAll()).thenReturn(dinos);
		
		MvcResult result = mockMvc.perform(get("/dinos/v1")).andExpect(status().isOk()).andReturn();
		
		assertThat(result.getResponse().getContentAsString()).isEqualToIgnoringCase(mapper.writeValueAsString(dinos));
		
		//test what the controller does and not have to worry about what the service does
		Assertions.assertNotNull(result.getResponse().getCookie("RaceWinner"));
	}
}
