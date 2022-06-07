package com.alexlepsa.contoller;

import com.alexlepsa.contoller.model.CommandChangePlayerColor;
import com.alexlepsa.contoller.model.CommandRemovePlayer;
import com.alexlepsa.contoller.model.RoomCommandMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import lombok.val;

import java.util.HashMap;

@Validated
@Controller("/room-command")
@Tag(name = "Room Commands")
public class RoomCommandController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    private WebsocketController websocketController;


    @Post("/change-player-color")
    @SneakyThrows
    public HttpResponse<String> sendPlayerColorChangeCommand(@Body CommandChangePlayerColor command) {
        val roomCommandMessage = new RoomCommandMessage(command.getRoomId(), CommandChangePlayerColor.TYPE, new HashMap<>() {{
            put("Player", command.getPlayer());
            put("NewColorIndex", command.getNewColorIndex());
        }});

        val emitResult = websocketController.getCommands().tryEmitNext(objectMapper.writeValueAsString(roomCommandMessage));

        return emitResult.isSuccess() ? HttpResponse.ok() : HttpResponse.serverError();
    }

    @Post("/remove-player")
    @SneakyThrows
    public HttpResponse<String> sendRemovePlayerCommand(@Body CommandRemovePlayer command) {
        val roomCommandMessage = new RoomCommandMessage(command.getRoomId(), CommandRemovePlayer.TYPE, new HashMap<>() {{
            put("Player", command.getPlayer());
        }});

        val emitResult = websocketController.getCommands().tryEmitNext(objectMapper.writeValueAsString(roomCommandMessage));

        return emitResult.isSuccess() ? HttpResponse.ok() : HttpResponse.serverError();
    }
}
