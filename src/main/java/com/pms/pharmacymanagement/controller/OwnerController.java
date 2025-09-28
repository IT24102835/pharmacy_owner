package com.pms.pharmacymanagement.controller;

import com.pms.pharmacymanagement.model.FinancialPlan;
import com.pms.pharmacymanagement.model.Staff;
import com.pms.pharmacymanagement.service.FinancialService;
import com.pms.pharmacymanagement.service.StaffActivityLogService;
import com.pms.pharmacymanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private FinancialService financialService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffActivityLogService staffActivityLogService;

    @GetMapping("/dashboard")
    public String ownerDashboard(Model model) {
        // Add attributes for the dashboard view
        model.addAttribute("financialPlans", financialService.getAllFinancialPlans());
        model.addAttribute("budgetReports", financialService.getAllBudgetReports());
        model.addAttribute("staffCount", staffService.getAllStaff().size());
        return "owner/dashboard";
    }

    // Financial Management
    @GetMapping("/finance")
    public String financeDashboard(Model model) {
        model.addAttribute("financialPlans", financialService.getAllFinancialPlans());
        model.addAttribute("budgetReports", financialService.getAllBudgetReports());
        model.addAttribute("paymentConfigs", financialService.getAllPaymentConfigurations());
        model.addAttribute("newPlan", new FinancialPlan());
        return "owner/finance";
    }

    @PostMapping("/finance/plans")
    public String addFinancialPlan(@ModelAttribute FinancialPlan plan, @AuthenticationPrincipal UserDetails userDetails) {
        Staff currentUser = staffService.findByUsername(userDetails.getUsername());
        plan.setCreatedBy(currentUser);
        financialService.createFinancialPlan(plan);
        staffActivityLogService.logActivity(currentUser, "CREATE_FINANCIAL_PLAN", "Created new financial plan: " + plan.getPlanName());
        return "redirect:/owner/finance";
    }

    // Staff Management
    @GetMapping("/staff")
    public String manageStaff(Model model) {
        model.addAttribute("staffList", staffService.getAllStaff());
        model.addAttribute("newStaff", new Staff());
        return "owner/staff";
    }

    @PostMapping("/staff")
    public String addStaff(@ModelAttribute Staff staff, @AuthenticationPrincipal UserDetails userDetails) {
        staffService.createStaff(staff);
        Staff currentUser = staffService.findByUsername(userDetails.getUsername());
        staffActivityLogService.logActivity(currentUser, "CREATE_STAFF", "Created new staff member: " + staff.getUsername());
        return "redirect:/owner/staff";
    }

    @PostMapping("/staff/update/{id}")
    public String updateStaff(@PathVariable int id, @ModelAttribute Staff staff, @AuthenticationPrincipal UserDetails userDetails) {
        staffService.updateStaff(id, staff);
        Staff currentUser = staffService.findByUsername(userDetails.getUsername());
        staffActivityLogService.logActivity(currentUser, "UPDATE_STAFF", "Updated staff member: " + staff.getUsername());
        return "redirect:/owner/staff";
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable int id, @AuthenticationPrincipal UserDetails userDetails) {
        Staff staffToDelete = staffService.getStaffById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        staffService.deleteStaff(id);
        Staff currentUser = staffService.findByUsername(userDetails.getUsername());
        staffActivityLogService.logActivity(currentUser, "DELETE_STAFF", "Deleted staff member: " + staffToDelete.getUsername());
        return "redirect:/owner/staff";
    }

    // Activity Logs
    @GetMapping("/logs")
    public String viewActivityLogs(Model model) {
        model.addAttribute("logs", staffActivityLogService.getAllLogs());
        return "owner/activity-logs";
    }
}