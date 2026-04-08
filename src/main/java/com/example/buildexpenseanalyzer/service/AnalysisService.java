package com.example.buildexpenseanalyzer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buildexpenseanalyzer.Repo.ExpenseRepo;
import com.example.buildexpenseanalyzer.Repo.ProjectRepo;
import com.example.buildexpenseanalyzer.model.Expense;
import com.example.buildexpenseanalyzer.model.Project;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AnalysisService {
    private final ExpenseRepo expenseRepo;
    private final ProjectRepo projectRepo;
    public double total(Long projectId){
        return expenseRepo.findByProjectId(projectId).stream().mapToDouble(Expense::getAmount).sum();
    }
    public boolean isOverSpending(Long projectId){
        Project p = projectRepo.findById(projectId).orElseThrow(() -> new RuntimeException("not found"));
        double total = total(projectId);
        return total>p.getBudget()*0.8;
    }
    public String buildSummary(Long projectId){
        Project p = projectRepo.findById(projectId).get();
        List<Expense> expenses = expenseRepo.findByProjectId(projectId);
        StringBuilder sb = new StringBuilder();
        sb.append("project: ").append(p.getName()).append("/n");
        sb.append("Budget: ").append(p.getBudget()).append("/n").append("Total spend").append(total(projectId));
        sb.append("Expenses:/n");
        for(Expense e : expenses){
            sb.append("- ")
                .append(e.getTitle())
                .append("|")
                .append(e.getCategory())
                .append("|")
                .append(e.getAmount())
                .append("/n");
        }
        return sb.toString();
    }
}
