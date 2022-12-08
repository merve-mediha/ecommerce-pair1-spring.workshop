package com.etiya.ecommercedemopair1.business.abstracts.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
