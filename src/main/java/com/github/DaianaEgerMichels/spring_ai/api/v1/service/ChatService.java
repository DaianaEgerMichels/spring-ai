package com.github.DaianaEgerMichels.spring_ai.api.v1.service;

import com.github.DaianaEgerMichels.spring_ai.api.v1.dto.request.ChatRequest;
import com.github.DaianaEgerMichels.spring_ai.api.v1.dto.response.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public ChatResponse chat(ChatRequest chatRequest) {
        return new ChatResponse(this.chatClient.prompt()
                .user(chatRequest.message())
                .call()
                .content());
    }
}
