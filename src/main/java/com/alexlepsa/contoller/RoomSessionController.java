package com.alexlepsa.contoller;

import com.alexlepsa.repository.RoomSessionRepository;
import com.alexlepsa.repository.model.RoomSession;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import lombok.val;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Validated
@Controller("/room-session")
public class RoomSessionController {

    @Inject
    private WebsocketController websocketController;

    @Inject
    private RoomSessionRepository roomSessionRepository;

    @Get()
    public HttpResponse<List<RoomSession>> getAllRoomSessions() {
        List<RoomSession> roomSessions = new ArrayList<>();
        roomSessionRepository.findAll().iterator().forEachRemaining(roomSessions::add);
        return HttpResponse.ok(roomSessions);
    }

    @Post()
    public HttpResponse<String> sendCommandToSession(@Body String command) {
        val emitResult = websocketController.getCommands().tryEmitNext(command);

        return emitResult.isSuccess() ? HttpResponse.ok() : HttpResponse.serverError();
    }
}