package com.altimetrik.bus.validator;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.altimetrik.bus.model.RequestPayload;
import com.altimetrik.bus.model.ResponsePayload;


@RunWith(SpringRunner.class)
public class SearchValidatorTest {

	@TestConfiguration
	static class TestConfig{
		@Bean
		SearchValidator searchValidator() {
			return new SearchValidator();
		}
	}
	
	@Autowired
	private SearchValidator searchValidator;
	
	@Test
	public void test() {
		RequestPayload request = new RequestPayload();
		request.setSourceCity("A");
		request.setDestinationCity("D");
		request.setTravelDate("2020-09-02");
		ResponsePayload res = searchValidator.validate(request);
		assertNotNull(res);
	}
}
