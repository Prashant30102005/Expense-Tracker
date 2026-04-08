package com.example.buildexpenseanalyzer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.buildexpenseanalyzer.service.AnalysisService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AnaysisController {
    private final AnalysisService analysisService;

    @GetMapping("/total/{id}")
    public double total(@PathVariable Long id) {
        return analysisService.total(id);
    }
    @GetMapping("/overspending/{id}")
    public boolean overspending(@PathVariable Long id) {
        return analysisService.isOverSpending(id);
    }
    
}
