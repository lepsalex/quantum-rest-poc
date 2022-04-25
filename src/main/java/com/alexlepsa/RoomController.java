package com.alexlepsa;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import lombok.val;

import javax.validation.Valid;
import java.util.UUID;

@Validated
@Controller("/room")
public class RoomController {

    @Inject
    private RoomRepository roomRepository;

    @Post()
    public HttpResponse<String> saveRoom(@Body @Valid Room room) {
        roomRepository.save(room);
        return HttpResponse.created("Saved successfully !");
    }

    @Get("/{roomId}")
    public HttpResponse<Room> getRoomById(String roomId) {
        val room = roomRepository.findById(roomId);
        return room.map(HttpResponse::created).orElse(HttpResponse.notFound());
    }
}
