package com.pms.pharmacymanagement.repository;

import com.pms.pharmacymanagement.model.PaymentConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentConfigurationRepository extends JpaRepository<PaymentConfiguration, Integer> {
}