package com.altimetrik.bus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.bus.model.RequestPayload;
import com.altimetrik.bus.model.ResponsePayload;
import com.altimetrik.bus.model.RouteInformation;
import com.altimetrik.bus.validator.SearchValidator;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	protected SearchValidator validator;

	@Override
	public ResponsePayload getSearchResult(RequestPayload request) {

		ResponsePayload response = validator.validate(request);

		if (!response.getErrors().isEmpty()) {
			return response;
		}
		List<RouteInformation> list = getResult(request);
		response.setRouteList(list);
		response.setTotal(list.size());

		return response;
	}

	private List<RouteInformation> getResult(RequestPayload request) {

		String source = request.getSourceCity();
		String destination = request.getDestinationCity();
		String date = request.getTravelDate();

		List<RouteInformation> routeList = new ArrayList<RouteInformation>();

		routeList.add(new RouteInformation("A0001", "Linh", "10", "10.15", "15", "3", "A", "B"));
		routeList.add(new RouteInformation("A0001", "Linh", "10.15", "10.45", "30", "5", "B", "C"));
		routeList.add(new RouteInformation("A0001", "Linh", "10.45", "10.55", "10", "4", "C", "D"));
		routeList.add(new RouteInformation("A0001", "Linh", "10.55", "11.15", "20", "7", "D", "E"));

		routeList.add(new RouteInformation("A0002", "Jhon", "13", "13.15", "15", "3", "A", "B"));
		routeList.add(new RouteInformation("A0002", "Jhon", "13.15", "13.45", "30", "5", "B", "C"));
		routeList.add(new RouteInformation("A0002", "Jhon", "13.45", "13.55", "10", "4", "C", "D"));
		routeList.add(new RouteInformation("A0002", "Jhon", "13.55", "14.15", "20", "7", "D", "E"));

		routeList.add(new RouteInformation("B0001", "Kim", "10", "10.15", "15", "3", "F", "G"));
		routeList.add(new RouteInformation("B0001", "Kim", "10.15", "10.45", "30", "5", "G", "H"));
		routeList.add(new RouteInformation("B0001", "Kim", "10.45", "10.55", "10", "4", "I", "J"));
		routeList.add(new RouteInformation("B0001", "Kim", "10.55", "11.15", "20", "7", "K", "L"));

		routeList.add(new RouteInformation("B0002", "Don", "116", "16.15", "15", "3", "F", "G"));
		routeList.add(new RouteInformation("B0002", "Don", "16.15", "16.45", "30", "5", "G", "H"));
		routeList.add(new RouteInformation("B0002", "Don", "16.45", "16.55", "10", "4", "I", "J"));
		routeList.add(new RouteInformation("B0002", "Don", "16.55", "16.15", "20", "7", "K", "L"));

		String busNumber;
		String operatorName;
		String departureTime;
		RouteInformation route;
		List<RouteInformation> result = new ArrayList<RouteInformation>();

		for (RouteInformation routeInfo : routeList) {
			if (routeInfo.getSource().equals(source)) {
				busNumber = routeInfo.getBusNumber();
				operatorName = routeInfo.getOperatorName();
				departureTime = routeInfo.getDepartureTime();

				route = new RouteInformation(busNumber, operatorName, departureTime);
				result.add(route);
			}
		}

		boolean hasRoute = false;

		for (RouteInformation routeInfo : routeList) {
			if (routeInfo.getDestination().equals(destination)) {
				for (RouteInformation resltRoute : result) {
					if (routeInfo.getBusNumber().equals(resltRoute.getBusNumber())) {
						resltRoute.setArrivalTime(routeInfo.getArrivalTime());
						resltRoute.setDuration(String.valueOf(Double.parseDouble(resltRoute.getArrivalTime())
								- Double.parseDouble(routeInfo.getDepartureTime())));
						hasRoute = true;
					}
				}
			}
		}
		if (!hasRoute) {
			result = new ArrayList<RouteInformation>();
		}
		return result;
	}
}