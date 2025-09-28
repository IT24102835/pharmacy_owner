package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.FinancialPlan;
import com.pms.pharmacymanagement.model.BudgetReport;
import com.pms.pharmacymanagement.repository.FinancialPlanRepository;
import com.pms.pharmacymanagement.repository.BudgetReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinancialPlanRepository financialPlanRepository;

    @Autowired
    private BudgetReportRepository budgetReportRepository;

    // Financial Plan methods
    @Override
    public List<FinancialPlan> getAllFinancialPlans() {
        return financialPlanRepository.findAll();
    }

    @Override
    public FinancialPlan getFinancialPlanById(Long id) {
        return financialPlanRepository.findById(id).orElse(null);
    }

    @Override
    public void saveFinancialPlan(FinancialPlan financialPlan) {
        financialPlanRepository.save(financialPlan);
    }

    @Override
    public void deleteFinancialPlan(Long id) {
        financialPlanRepository.deleteById(id);
    }

    // Budget Report methods
    @Override
    public List<BudgetReport> getAllBudgetReports() {
        return budgetReportRepository.findAll();
    }

    @Override
    public BudgetReport getBudgetReportById(Long id) {
        return budgetReportRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBudgetReport(BudgetReport budgetReport) {
        budgetReportRepository.save(budgetReport);
    }

    @Override
    public void deleteBudgetReport(Long id) {
        budgetReportRepository.deleteById(id);
    }
}