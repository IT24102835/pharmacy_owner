package com.pms.pharmacymanagement.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "budget_reports")
public class BudgetReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private int reportId;

    @Column(name = "report_name", nullable = false)
    private String reportName;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "plan_id")
    private FinancialPlan financialPlan;

    @Column(name = "total_budget", nullable = false, precision = 19, scale = 2)
    private BigDecimal totalBudget;

    @Column(name = "spent_budget", precision = 19, scale = 2, columnDefinition = "DECIMAL(19,2) DEFAULT 0.00")
    private BigDecimal spentBudget;

    @Column(name = "generated_date", nullable = false)
    private Date generatedDate;

    private String details;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "staff_id")
    private Staff createdBy;

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public FinancialPlan getFinancialPlan() {
        return financialPlan;
    }

    public void setFinancialPlan(FinancialPlan financialPlan) {
        this.financialPlan = financialPlan;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }

    public BigDecimal getSpentBudget() {
        return spentBudget;
    }

    public void setSpentBudget(BigDecimal spentBudget) {
        this.spentBudget = spentBudget;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Staff getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Staff createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}