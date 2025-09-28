package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.BudgetReport;
import com.pms.pharmacymanagement.model.FinancialPlan;
import com.pms.pharmacymanagement.model.PaymentConfiguration;
import com.pms.pharmacymanagement.repository.BudgetReportRepository;
import com.pms.pharmacymanagement.repository.FinancialPlanRepository;
import com.pms.pharmacymanagement.repository.PaymentConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    @Autowired
    private FinancialPlanRepository financialPlanRepository;

    @Autowired
    private BudgetReportRepository budgetReportRepository;

    @Autowired
    private PaymentConfigurationRepository paymentConfigurationRepository;

    // Financial Plan Methods
    public List<FinancialPlan> getAllFinancialPlans() {
        return financialPlanRepository.findAll();
    }

    public FinancialPlan createFinancialPlan(FinancialPlan plan) {
        return financialPlanRepository.save(plan);
    }

    public FinancialPlan updateFinancialPlan(int id, FinancialPlan planDetails) {
        FinancialPlan plan = financialPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Financial plan not found with id: " + id));
        plan.setPlanName(planDetails.getPlanName());
        plan.setDescription(planDetails.getDescription());
        plan.setStartDate(planDetails.getStartDate());
        plan.setEndDate(planDetails.getEndDate());
        plan.setStatus(planDetails.getStatus());
        return financialPlanRepository.save(plan);
    }

    public void deleteFinancialPlan(int id) {
        financialPlanRepository.deleteById(id);
    }

    // Budget Report Methods
    public List<BudgetReport> getAllBudgetReports() {
        return budgetReportRepository.findAll();
    }

    public BudgetReport createBudgetReport(BudgetReport report) {
        return budgetReportRepository.save(report);
    }

    // Payment Configuration Methods
    public List<PaymentConfiguration> getAllPaymentConfigurations() {
        return paymentConfigurationRepository.findAll();
    }

    public PaymentConfiguration createPaymentConfiguration(PaymentConfiguration config) {
        return paymentConfigurationRepository.save(config);
    }

    public void deletePaymentConfiguration(int id) {
        paymentConfigurationRepository.deleteById(id);
    }
}