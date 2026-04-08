package com.example.buildexpenseanalyzer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.buildexpenseanalyzer.service.AiAnalysisService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AiController {
    private final AiAnalysisService aiAnalysisService;
    @GetMapping("/insights/{id}")
    public String insighs(@PathVariable Long id) {
        System.out.println("API KEY = " + System.getenv("GEMINI_API_KEY"));
        return aiAnalysisService.getInsights(id);
    }
    
 
    
    
}
