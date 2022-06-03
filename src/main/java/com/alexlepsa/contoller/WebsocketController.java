package com.alexlepsa.contoller;

import com.alexlepsa.contoller.model.RoomConnectionMessage;
import com.alexlepsa.repository.RoomSessionRepository;
import com.alexlepsa.repository.model.RoomSession;
import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ServerWebSocket("/ws/commands")
public class WebsocketController {

    @Inject
    private RoomSessionRepository roomSessionRepository;

    @Inject
    private WebSocketBroadcaster broadcaster;

    @OnOpen
    public void onOpen(WebSocketSession session) {
        log.info("New websocket connection: {}", session);
    }

    @OnMessage
    public void onMessage(
            RoomConnectionMessage message,
            WebSocketSession session) {
        log.info(message.toString());
        switch (message.getRoomStatus()) {
            case OPEN -> roomSessionRepository.update(new RoomSession(message.getRoomId()));
            case CLOSED -> roomSessionRepository.deleteById(message.getRoomId());
        }
    }
}
