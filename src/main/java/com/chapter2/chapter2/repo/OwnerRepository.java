package com.chapter2.chapter2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chapter2.chapter2.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
	
	
}
