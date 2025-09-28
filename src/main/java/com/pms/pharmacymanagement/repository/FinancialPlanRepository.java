package com.pms.pharmacymanagement.repository;

import com.pms.pharmacymanagement.model.FinancialPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialPlanRepository extends JpaRepository<FinancialPlan, Integer> {
}