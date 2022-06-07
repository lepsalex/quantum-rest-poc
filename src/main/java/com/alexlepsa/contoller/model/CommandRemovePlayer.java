package com.alexlepsa.contoller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandRemovePlayer {
    public static final String TYPE = "CommandRemovePlayer";

    private String roomId;
    private Integer player;
}
