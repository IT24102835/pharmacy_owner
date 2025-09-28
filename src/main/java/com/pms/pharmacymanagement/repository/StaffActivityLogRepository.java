package com.pms.pharmacymanagement.repository;

import com.pms.pharmacymanagement.model.StaffActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffActivityLogRepository extends JpaRepository<StaffActivityLog, Integer> {
}