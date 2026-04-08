package com.example.buildexpenseanalyzer.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    private String name;
    private double budget;
    private LocalDate startDate;
    private LocalDate endDate;
}
