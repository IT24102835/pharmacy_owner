package com.pms.pharmacymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("/dashboard")
    public String staffDashboard(Model model) {
        // A simple dashboard for staff members
        model.addAttribute("message", "Welcome to the Staff Dashboard!");
        return "staff/dashboard";
    }
}