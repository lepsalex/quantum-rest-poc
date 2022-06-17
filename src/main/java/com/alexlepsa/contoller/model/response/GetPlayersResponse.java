package com.alexlepsa.contoller.model.response;

import com.alexlepsa.contoller.model.common.AccountId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlayersResponse {
    private Result result;
    private List<AccountId> accountIds;

    public enum Result {
        RESULT_OK,
        RESULT_SPACE_INSTANCE_NOT_FOUND
    }
}
