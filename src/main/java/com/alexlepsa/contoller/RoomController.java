package com.alexlepsa.contoller;

import com.alexlepsa.repository.RoomRepository;
import com.alexlepsa.repository.model.Room;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import lombok.val;

import javax.validation.Valid;

import static com.alexlepsa.contoller.common.AuthUtils.AUTH_HEADER;
import static com.alexlepsa.contoller.common.AuthUtils.isAccountIdAuthed;

@Validated
@Controller("/room")
@Tag(name = "Room State")
public class RoomController {

    @Inject
    private RoomRepository roomRepository;

    @Post()
    public HttpResponse<String> saveRoom(@Header(AUTH_HEADER) String authToken, @Body @Valid Room room) {
        if (!isAccountIdAuthed(authToken)) {
            return HttpResponse.unauthorized();
        }

        roomRepository.update(room);
        return HttpResponse.created("Saved successfully !");
    }

    @Get("/{roomId}")
    public HttpResponse<Room> getRoomById(@Header(AUTH_HEADER) String authToken, String roomId) {
        if (!isAccountIdAuthed(authToken)) {
            return HttpResponse.unauthorized();
        }

        val room = roomRepository.findById(roomId);
        return room.map(HttpResponse::ok).orElse(HttpResponse.notFound());
    }
}
