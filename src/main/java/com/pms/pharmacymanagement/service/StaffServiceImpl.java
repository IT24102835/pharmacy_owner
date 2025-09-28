package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.Staff;
import com.pms.pharmacymanagement.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}