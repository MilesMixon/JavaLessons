package com.skillstorm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.skillstorm.beans.Owner;
import com.skillstorm.models.OwnerModel;
import com.skillstorm.services.OwnerService;

@SpringBootTest
public class MockitoTests {

	//maybe i just want to test one piece
	//mocking helps with this, i can make a fake version of a Bean
	@MockBean
	private OwnerService service;
	// this gives me a service and all of the methods, but fake versions
	
	//not a good test, but shows what mocking does
	@Test
	@Disabled
	void findByNameSimilar() {
		OwnerModel idOwner = new OwnerModel(3, "Dan Pickles", "Red", "Steak", 23);
		
		//i control what is returned from my mocked methods
		OwnerModel ret = (OwnerModel) Mockito.when(service.findById(3)).thenReturn(idOwner);
		
		Assertions.assertEquals(3, ret.getId());
	}
}
