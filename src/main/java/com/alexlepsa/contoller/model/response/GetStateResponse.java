package com.alexlepsa.contoller.model.response;

import com.alexlepsa.contoller.model.common.PlayerState;
import com.alexlepsa.contoller.model.common.SpaceState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetStateResponse {
    private Result result;
    private SpaceState space;
    private List<PlayerState> players;

    public enum Result {
        RESULT_OK,
        RESULT_NOT_FOUND,
        RESULT_INCOMPATIBLE_VERSION_FOUND,
        RESULT_USER_IS_NOT_IN_SPACE_INSTANCE
    }
}
