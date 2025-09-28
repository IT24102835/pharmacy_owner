package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.Staff;
import com.pms.pharmacymanagement.model.StaffActivityLog;
import com.pms.pharmacymanagement.repository.StaffActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffActivityLogService {

    @Autowired
    private StaffActivityLogRepository staffActivityLogRepository;

    public void logActivity(Staff staff, String activityType, String description) {
        StaffActivityLog log = new StaffActivityLog();
        log.setStaff(staff);
        log.setActivityType(activityType);
        log.setDescription(description);
        staffActivityLogRepository.save(log);
    }

    public List<StaffActivityLog> getAllLogs() {
        return staffActivityLogRepository.findAll();
    }
}