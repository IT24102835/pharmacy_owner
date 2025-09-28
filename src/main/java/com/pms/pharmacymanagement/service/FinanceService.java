package com.pms.pharmacymanagement.service;

import com.pms.pharmacymanagement.model.FinancialPlan;
import com.pms.pharmacymanagement.model.BudgetReport;
import java.util.List;

public interface FinanceService {
    // Financial Plan methods
    List<FinancialPlan> getAllFinancialPlans();
    FinancialPlan getFinancialPlanById(Long id);
    void saveFinancialPlan(FinancialPlan financialPlan);
    void deleteFinancialPlan(Long id);

    // Budget Report methods
    List<BudgetReport> getAllBudgetReports();
    BudgetReport getBudgetReportById(Long id);
    void saveBudgetReport(BudgetReport budgetReport);
    void deleteBudgetReport(Long id);
}