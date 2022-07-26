package com.delivery.backend.repository;

import com.delivery.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
