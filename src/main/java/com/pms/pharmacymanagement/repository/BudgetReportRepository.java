package com.pms.pharmacymanagement.repository;

import com.pms.pharmacymanagement.model.BudgetReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetReportRepository extends JpaRepository<BudgetReport, Long> {
}