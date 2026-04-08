package com.example.buildexpenseanalyzer.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiAnalysisService {
    private final AnalysisService analysisService;
    private final AiService aiService;
    public String getInsights(Long projectId){
        String summary = analysisService.buildSummary(projectId);
        return aiService.analyze(summary);
    }
}

