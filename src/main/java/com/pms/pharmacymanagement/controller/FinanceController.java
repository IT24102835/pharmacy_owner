package com.pms.pharmacymanagement.controller;

import com.pms.pharmacymanagement.model.FinancialPlan;
import com.pms.pharmacymanagement.model.BudgetReport;
import com.pms.pharmacymanagement.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("financialPlans", financeService.getAllFinancialPlans());
        model.addAttribute("budgetReports", financeService.getAllBudgetReports());
        return "finance/dashboard";
    }

    // Financial Plans
    @GetMapping("/plans")
    public String listPlans(Model model) {
        model.addAttribute("plans", financeService.getAllFinancialPlans());
        return "finance/plans";
    }

    @GetMapping("/plans/new")
    public String newPlanForm(Model model) {
        model.addAttribute("plan", new FinancialPlan());
        return "finance/plan-form";
    }

    @PostMapping("/plans")
    public String savePlan(@ModelAttribute FinancialPlan plan) {
        financeService.saveFinancialPlan(plan);
        return "redirect:/finance/dashboard";
    }

    // Budget Reports
    @GetMapping("/reports")
    public String listReports(Model model) {
        model.addAttribute("reports", financeService.getAllBudgetReports());
        return "finance/reports";
    }

    @GetMapping("/reports/new")
    public String newReportForm(Model model) {
        model.addAttribute("report", new BudgetReport());
        return "finance/report-form";
    }

    @PostMapping("/reports")
    public String saveReport(@ModelAttribute BudgetReport report) {
        financeService.saveBudgetReport(report);
        return "redirect:/finance/dashboard";
    }
}