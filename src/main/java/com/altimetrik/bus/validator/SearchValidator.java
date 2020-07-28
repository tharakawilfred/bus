package com.altimetrik.bus.validator;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.altimetrik.bus.model.RequestPayload;
import com.altimetrik.bus.model.ResponsePayload;

@Component
public class SearchValidator {

	public ResponsePayload validate(RequestPayload request) {
		HashMap<String, String> errors = new HashMap<String, String>();
		ResponsePayload response = new ResponsePayload();

		if (StringUtils.isEmpty(request.getSourceCity())) {
			errors.put("SourceCity", "SourceCity can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getDestinationCity())) {
			errors.put("DestinationCity", "DestinationCity can't be null or empty");
		}
		if (StringUtils.isEmpty(request.getTravelDate())) {
			errors.put("TravelDate", "TravelDate can't be null or empty");
		}
		response.setErrors(errors);
		return response;
	}
}
