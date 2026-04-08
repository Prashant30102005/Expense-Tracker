package com.example.buildexpenseanalyzer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.buildexpenseanalyzer.Dto.ExpenseDto;
import com.example.buildexpenseanalyzer.service.ExpenseService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("expenses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExpenseController {
    private final ExpenseService expenseService;
    @PostMapping("add/{projectId}")
    public ExpenseDto addExpense(@RequestBody ExpenseDto expenseDto ,@PathVariable Long projectId) {
        return expenseService.addExpense(expenseDto, projectId);
    }
    @GetMapping("/project/{id}")
    public List<ExpenseDto> getAllExpenses(@PathVariable Long id) {
        return expenseService.getAllExpenses(id);
    }
    @DeleteMapping("delete/{id}")
    public String deleteProject(@PathVariable Long id){
        return expenseService.deleteById(id);
    }
    
}
