package com.pms.pharmacymanagement.repository;

import com.pms.pharmacymanagement.model.PaymentConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentConfigRepository extends JpaRepository<PaymentConfig, Long> {
}