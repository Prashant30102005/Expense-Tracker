package com.example.buildexpenseanalyzer.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buildexpenseanalyzer.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Long> {
    List<Expense>findByProjectId(Long projectId);
}
