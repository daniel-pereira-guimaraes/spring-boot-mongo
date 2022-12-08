package com.example.springbootmongo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class PersonAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String number;
	private String district;
	private String city;
	private String state;

	public PersonAddress() {
		
	}

	public PersonAddress(String street, String number, String district, String city, String state) {
		super();
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "PersonAddress [street=" + street + ", number=" + number + ", district=" + district + ", city=" + city
				+ ", state=" + state + "]";
	}
	
}
