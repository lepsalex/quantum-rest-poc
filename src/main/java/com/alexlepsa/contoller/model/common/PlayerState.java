package com.alexlepsa.contoller.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerState {
    private AccountId accountId;
    private String  stateJson;
}
