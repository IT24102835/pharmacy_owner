package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.Staff;
import com.pms.pharmacymanagement.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(int id) {
        return staffRepository.findById(id);
    }

    public Staff createStaff(Staff staff) {
        // Additional logic can be added here, e.g., validation
        return staffRepository.save(staff);
    }

    public Staff updateStaff(int id, Staff staffDetails) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));

        staff.setUsername(staffDetails.getUsername());
        staff.setRole(staffDetails.getRole());
        staff.setActive(staffDetails.isActive());

        // Password update should be handled carefully, maybe in a separate method
        if (staffDetails.getPassword() != null && !staffDetails.getPassword().isEmpty()) {
            staff.setPassword(staffDetails.getPassword());
        }

        return staffRepository.save(staff);
    }

    public void deleteStaff(int id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));
        staffRepository.delete(staff);
    }

    public Staff findByUsername(String username) {
        return staffRepository.findByUsername(username).orElse(null);
    }
}