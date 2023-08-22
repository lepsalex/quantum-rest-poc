package com.alexlepsa.contoller.model.request;

import com.alexlepsa.contoller.model.common.BunchverseArtifactVersion;
import com.alexlepsa.contoller.model.common.SpaceInstanceId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetStateRequest {
    private SpaceInstanceId spaceInstanceId;
    private BunchverseArtifactVersion bunchverseArtifactVersion;
}
