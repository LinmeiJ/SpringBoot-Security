package com.chapter2.chapter2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ownerId;
	private String firstName, lastName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner") 
	@JsonIgnore 
	private List<Car> cars;

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public Owner(Long ownerId, String firstName, String lastName, List<Car> cars) {
		super();
		this.ownerId = ownerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cars = cars;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	

}
