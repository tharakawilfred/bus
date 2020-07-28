package com.altimetrik.bus.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.altimetrik.bus.model.RequestPayload;
import com.altimetrik.bus.model.ResponsePayload;
import com.altimetrik.bus.validator.SearchValidator;

@RunWith(SpringRunner.class)
public class SearchServiceImplTest {

	@TestConfiguration
	static class TestConfig {
		@Bean
		SearchServiceImpl getSearchServiceImpl() {
			return new SearchServiceImpl();
		}
	}

	@Autowired
	SearchServiceImpl service;

	@MockBean
	SearchValidator validator;

	@Test
	public void test() {
		RequestPayload request = new RequestPayload();
		request.setSourceCity("A");
		request.setDestinationCity("D");
		request.setTravelDate("2020-09-02");

		HashMap<String, String> errors = new HashMap<String, String>();
		ResponsePayload response = new ResponsePayload();
		response.setErrors(errors);

		Mockito.when(validator.validate(request)).thenReturn(response);
		ResponsePayload res = service.getSearchResult(request);

		assertEquals(0, res.getErrors().size());
	}
}
