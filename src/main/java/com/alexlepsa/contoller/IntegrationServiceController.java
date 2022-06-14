package com.alexlepsa.contoller;

import com.alexlepsa.contoller.model.common.PlayerState;
import com.alexlepsa.contoller.model.common.SpaceState;
import com.alexlepsa.contoller.model.request.DeleteStateRequest;
import com.alexlepsa.contoller.model.request.GetStateRequest;
import com.alexlepsa.contoller.model.request.SaveStateRequest;
import com.alexlepsa.contoller.model.response.DeleteStateResponse;
import com.alexlepsa.contoller.model.response.GetStateResponse;
import com.alexlepsa.contoller.model.response.SaveStateResponse;
import com.alexlepsa.repository.RoomRepository;
import com.alexlepsa.repository.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import lombok.val;

import java.util.Arrays;
import java.util.List;

@Validated
@Controller("/integration-service")
@Tag(name = "Integration Service")
public class IntegrationServiceController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Inject
    private RoomRepository roomRepository;

    @Post("/saveState")
    @SneakyThrows
    public HttpResponse<SaveStateResponse> saveState(@Body SaveStateRequest request) {
        val room = new Room();
        room.setRoomId(request.getSpace().getSpaceInstanceId().getId());
        room.setPlayerStates(objectMapper.writeValueAsString(request.getPlayers()));

        roomRepository.save(room);

        return HttpResponse.ok(new SaveStateResponse(SaveStateResponse.Result.RESULT_OK));
    }

    @Post("/getState")
    @SneakyThrows
    public HttpResponse<GetStateResponse> getState(@Body GetStateRequest request) {
        return roomRepository.findById(request.getSpaceInstanceId().getId()).map(
                        foundRoom -> HttpResponse.ok(new GetStateResponse(
                                GetStateResponse.Result.RESULT_OK,
                                new SpaceState(request.getSpaceInstanceId()),
                                parseStringToPlayerList(foundRoom.getPlayerStates()))))
                .orElse(HttpResponse.notFound(new GetStateResponse(GetStateResponse.Result.RESULT_NOT_FOUND, null, null)));
    }

    @Post("/deleteState")
    @SneakyThrows
    public HttpResponse<DeleteStateResponse> deleteState(@Body DeleteStateRequest request) {
        roomRepository.deleteById(request.getSpaceInstanceId().getId());

        return HttpResponse.ok(new DeleteStateResponse(DeleteStateResponse.Result.RESULT_OK));
    }

    @SneakyThrows
    private List<PlayerState> parseStringToPlayerList(String players) {
        return Arrays.asList(objectMapper.readValue(players, PlayerState[].class));
    }
}
