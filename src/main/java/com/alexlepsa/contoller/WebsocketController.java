package com.alexlepsa.contoller;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.ServerWebSocket;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;

@ServerWebSocket("/ws/commands")
public class WebsocketController {

    @Inject
    private WebSocketBroadcaster broadcaster;

    @OnMessage
    public Publisher<String> onMessage(
            String message,
            WebSocketSession session) {
        return broadcaster.broadcast(message);
    }
}
