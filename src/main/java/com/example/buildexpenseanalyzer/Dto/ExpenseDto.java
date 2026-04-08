package com.example.buildexpenseanalyzer.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseDto {
    private Long id;
    private String title;
    private double amount;
    private LocalDate date;
    private String category;
}
