package com.alexlepsa.contoller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandChangePlayerColor {
    public static final String TYPE = "CommandChangePlayerColor";

    private String roomId;
    private Integer player;
    private Integer newColorIndex;
}
