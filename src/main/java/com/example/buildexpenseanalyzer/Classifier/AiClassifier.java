package com.example.buildexpenseanalyzer.Classifier;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class AiClassifier {
    private final ChatClient chatClient;

    public AiClassifier(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    public String generateCategory(String title){
        System.out.println("API KEY = " + System.getenv("GEMINI_API_KEY"));

        return chatClient.prompt()
                            .system("""
                                    You are a Project expense classification AI.
                                    Your task is to classify a given title into EXACTLY ONE category.

                                    Rules:
                                    - Return ONLY one word
                                    - No sentence, no explanation
                                    - Use lowercase
                                    - Categories must be from Project domain  
                                    """)
                            .user("title "+title)
                            .call()
                            .content();        
    }
    

}
