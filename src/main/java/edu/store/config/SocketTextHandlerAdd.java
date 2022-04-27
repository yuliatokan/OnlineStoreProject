package edu.store.config;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SocketTextHandlerAdd extends TextWebSocketHandler {

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
        String payload = message.getPayload();
        JSONObject jsonObject = new JSONObject(payload);
        for (WebSocketSession webSocketSession : sessions) {
            webSocketSession.sendMessage(new TextMessage("<li class=\"in new\" id=\"" + jsonObject.get("id") + "\">" + jsonObject.get("item") + "</li>"));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }
}
