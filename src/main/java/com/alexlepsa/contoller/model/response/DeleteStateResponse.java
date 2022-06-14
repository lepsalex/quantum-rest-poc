package com.alexlepsa.contoller.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteStateResponse {
    private Result result;

    public enum Result {
        RESULT_OK
    }
}
