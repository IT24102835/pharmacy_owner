package com.pms.pharmacymanagement.controller;

import com.pms.pharmacymanagement.model.Staff;
import com.pms.pharmacymanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    public String listStaff(Model model) {
        model.addAttribute("staffList", staffService.getAllStaff());
        return "admin/staff";
    }

    @GetMapping("/staff/new")
    public String newStaffForm(Model model) {
        model.addAttribute("staff", new Staff());
        return "admin/staff-form";
    }

    @PostMapping("/staff")
    public String saveStaff(@ModelAttribute Staff staff) {
        staffService.saveStaff(staff);
        return "redirect:/admin/staff";
    }

    @GetMapping("/staff/edit/{id}")
    public String editStaffForm(@PathVariable Long id, Model model) {
        model.addAttribute("staff", staffService.getStaffById(id));
        return "admin/staff-form";
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return "redirect:/admin/staff";
    }
}