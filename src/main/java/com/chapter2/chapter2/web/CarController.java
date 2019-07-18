package com.chapter2.chapter2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chapter2.chapter2.entities.Car;
import com.chapter2.chapter2.repo.CarRepository;

@RestController
public class CarController {
	@Autowired
	private CarRepository cr;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){ 
		return cr.findAll();  
	}

}
