package com.chapter2.chapter2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chapter2.chapter2.entities.Car;

@RepositoryRestResource 
public interface CarRepository extends JpaRepository<Car, Long>{
	
	
	//Fetch cars by brand
	List<Car> findByBrand(@Param("brand") String brand);
	
	//Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
	//&&
	List<Car> findByBrandAndModel(String brand, String model); 
	// ||
	List<Car> findByBrandOrColor(String brand, String color);
	//queries can be sorted by using the OrderBy keyword
	List<Car> findByBrandOrderByYearAsc(String brand);
	
	//Another option: use @Query to find info.
	
//	@Query("select c from Car c where c.brand = ?1")
//	List<Car> findByBrand(String brand)；
	
	//@Query("select c from Car c where c.brand like %?1")  
	//List<Car> findByBrandEndsWith(String brand) 
		
}

