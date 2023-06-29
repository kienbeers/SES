package com.ses.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    public enum ChatMessageType {
        CHAT,JOIN, LEAVE
    }
    private ChatMessageType type;
    private String content;
    private String sender;


}
