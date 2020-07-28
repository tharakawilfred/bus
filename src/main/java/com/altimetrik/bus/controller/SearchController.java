package com.altimetrik.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.bus.model.RequestPayload;
import com.altimetrik.bus.model.ResponsePayload;
import com.altimetrik.bus.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	protected SearchService service;

	@PostMapping("/v1/bus/search")
	public ResponseEntity<?> searchBus(@RequestBody RequestPayload request) {

		ResponsePayload response = service.getSearchResult(request);

		if (response.getErrors() != null && !response.getErrors().isEmpty()) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}
		return ResponseEntity.ok(response);
	}
}