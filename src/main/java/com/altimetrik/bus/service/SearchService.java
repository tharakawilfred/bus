package com.altimetrik.bus.service;

import com.altimetrik.bus.model.RequestPayload;
import com.altimetrik.bus.model.ResponsePayload;

public interface SearchService {
	ResponsePayload getSearchResult(RequestPayload request);
}
