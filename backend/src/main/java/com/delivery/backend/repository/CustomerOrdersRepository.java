package com.delivery.backend.repository;

import com.delivery.backend.entity.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrdersRepository extends JpaRepository<CustomerOrders, Long> {
}
