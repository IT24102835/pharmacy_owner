package com.pms.pharmacymanagement.repository;

import com.pms.pharmacymanagement.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsername(String username);
}