package com.example.buildexpenseanalyzer.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;


@Service
public class AiService {
    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    public String analyze(String summary){
        String prompt = """
                        You are a Project cost analysis expert.

                        Analyze the following project data:

                        Project Name: %s
                        Total Budget: ₹%d
                        Total Expenses: ₹%d

                        Expense Breakdown:
                        %s

                        Provide the output in this exact format:

                        1. Budget Status :
                        (Safe / Risky / Critical reason)

                        2. Risk Prediction:
                        (Short explanation of risks based on spending pattern)

                        3. Budget Overrun Alert:
                        (Yes/No + short reason)

                        4. Top 3 Cost Saving Suggestions:
                        1. ...
                        2. ...
                        3. ...

                        5. Cost Optimization Summary:
                        (2–3 lines max)
                        
                        6. Generate catergoy wise suggestion for future expenses
                        Category-wise spending
                        % distribution
                        
                        7.  total budget 

                        Rules:
                        - Keep response concise and clear
                        - Use Indian Rupees (₹)
                        - No extra explanations
                        """+summary;
        return chatClient.prompt()
                            .user(prompt)
                            .call()
                            .content();        
    }
    
}
