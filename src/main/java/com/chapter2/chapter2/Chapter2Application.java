package com.chapter2.chapter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chapter2.chapter2.entities.Car;
import com.chapter2.chapter2.entities.Owner;
import com.chapter2.chapter2.repo.CarRepository;
import com.chapter2.chapter2.repo.OwnerRepository;

@SpringBootApplication
public class Chapter2Application {		
	@Autowired
	private CarRepository cr;
	
	@Autowired
	private OwnerRepository or;
	
	public static void main(String[] args) { 
		SpringApplication.run(Chapter2Application.class, args);
	}

	@Bean 
	CommandLineRunner runner() {
		return args -> {
			//add owners
			Owner o1 = new Owner("John","Johnson");
			Owner o2 = new Owner("Mary", "Robinson");
			or.save(o1);
			or.save(o2);
			cr.save(new Car("Ford","Mustang","Red","ADF-1121", 2017, 59000, o1));
			cr.save(new Car("Nissan","Leaf","White","SSJ-3002", 2014, 29000, o2));
			cr.save(new Car("Toyota","Prius","Silver","KKO-0212", 2018, 39000, o2));
		};
	}
}
