package com.github.DaianaEgerMichels.spring_ai.api.v1.controller;


import com.github.DaianaEgerMichels.spring_ai.api.v1.dto.request.ChatRequest;
import com.github.DaianaEgerMichels.spring_ai.api.v1.dto.response.ChatResponse;
import com.github.DaianaEgerMichels.spring_ai.api.v1.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/message")
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        return ResponseEntity.ok(this.chatService.chat(request));
    }
}
