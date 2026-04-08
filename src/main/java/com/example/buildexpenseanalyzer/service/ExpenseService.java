package com.example.buildexpenseanalyzer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buildexpenseanalyzer.Classifier.AiClassifier;
import com.example.buildexpenseanalyzer.Dto.ExpenseDto;
import com.example.buildexpenseanalyzer.Repo.ExpenseRepo;
import com.example.buildexpenseanalyzer.Repo.ProjectRepo;
import com.example.buildexpenseanalyzer.model.Expense;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepo expenseRepo;
    private final AiClassifier aiClassifier;
    private final ProjectRepo projectRepo;
    public ExpenseDto addExpense(ExpenseDto expenseDto, Long projectId) {
        Expense e = new Expense();
        e.setAmount(expenseDto.getAmount());
        e.setCategory(aiClassifier.generateCategory(expenseDto.getTitle()));
        e.setTitle(expenseDto.getTitle());
        e.setDate(expenseDto.getDate());
        e.setProject(projectRepo.findById(projectId).get());
        expenseRepo.save(e);
        return new ExpenseDto(e.getId(),e.getTitle(),e.getAmount(),e.getDate(),e.getCategory());
        
    }
    public List<ExpenseDto> getAllExpenses(Long id) {
        List<Expense> expenses = expenseRepo.findByProjectId(id);
        List<ExpenseDto> expenseDtos = new ArrayList<>();
        for(Expense e: expenses){
            expenseDtos.add(new ExpenseDto(e.getId(),e.getTitle(),e.getAmount(),e.getDate(),e.getCategory()));
        }
        return expenseDtos;
    }
    public String deleteById(Long id) {
        expenseRepo.deleteById(id);
        return "deleted";
    }

}
