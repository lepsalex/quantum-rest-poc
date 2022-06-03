package com.alexlepsa.contoller.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class RoomConnectionMessage {
    private String roomId;
    private RoomStatus roomStatus;

    public enum RoomStatus {
        OPEN,
        CLOSED
    }
}
