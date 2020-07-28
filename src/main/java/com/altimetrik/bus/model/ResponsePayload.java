package com.altimetrik.bus.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponsePayload {

	List<RouteInformation> routeList = new ArrayList<RouteInformation>();

	HashMap<String, String> errors;

	protected int total;

	public HashMap<String, String> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}

	public List<RouteInformation> getRouteList() {
		return routeList;
	}

	public void setRouteList(List<RouteInformation> routeList) {
		this.routeList = routeList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
