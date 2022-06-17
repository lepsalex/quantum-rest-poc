package com.alexlepsa.contoller.model.request;

import com.alexlepsa.contoller.model.common.SpaceInstanceId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlayersRequest {
    private SpaceInstanceId spaceInstanceId;
}
