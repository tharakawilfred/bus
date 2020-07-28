package com.altimetrik.bus.model;

public class RouteInformation {

	protected String busNumber;
	protected String operatorName;
	protected String departureTime;
	protected String arrivalTime;
	protected String duration;
	protected String price;
	protected String source;
	protected String destination;

	public String getBusNumber() {
		return busNumber;
	}

	public RouteInformation(String busNumber, String operatorName, String departureTime, String arrivalTime,
			String duration, String price, String source, String destination) {
		this.busNumber = busNumber;
		this.operatorName = operatorName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.price = price;
		this.source = source;
		this.destination = destination;
	}
	
	public RouteInformation(String busNumber, String operatorName, String departureTime) {
		this.busNumber = busNumber;
		this.operatorName = operatorName;
		this.departureTime = departureTime;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}