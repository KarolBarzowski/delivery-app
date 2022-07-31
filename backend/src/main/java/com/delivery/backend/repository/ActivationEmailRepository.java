package com.delivery.backend.repository;

import com.delivery.backend.entity.ActivationEmail;
import com.delivery.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationEmailRepository extends JpaRepository<ActivationEmail, Long> {
    ActivationEmail findActivationEmailByCustomer(Customer customer);
    ActivationEmail findActivationEmailByActivationCode(String UUID);
}
