package com.alexlepsa.contoller.model.request;

import com.alexlepsa.contoller.model.common.PlayerState;
import com.alexlepsa.contoller.model.common.BunchverseArtifactVersion;
import com.alexlepsa.contoller.model.common.SpaceState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveStateRequest {
    private SpaceState space;
    private List<PlayerState> players;
    private BunchverseArtifactVersion bunchverseArtifactVersion;
}
