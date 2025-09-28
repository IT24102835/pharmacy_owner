package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.Staff;
import java.util.List;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff getStaffById(Long id);
    void saveStaff(Staff staff);
    void deleteStaff(Long id);
}